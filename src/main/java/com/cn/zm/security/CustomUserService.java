package com.cn.zm.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cn.zm.dao.UrlsDao;
import com.cn.zm.dao.UserInfoDao;
import com.cn.zm.domain.Urls;
import com.cn.zm.domain.UserInfo;

/**
 * 
 * @author Administrator
 *
 */

@Component
public class CustomUserService implements UserDetailsService {
	@Autowired
    private UserInfoDao userInfoDao;
    @Autowired
	private UrlsDao urlsDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserInfo uinfo = userInfoDao.findByUsername(username);
            if(uinfo==null){
                return null;
            }
            return new User(uinfo.getUsername(),uinfo.getPassword(),getAuthorities(uinfo));
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found");
        }
    }
    private Set<GrantedAuthority> getAuthorities(UserInfo user){
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        //获取用户权限
        List<Urls> userUrls = getUrlsFromUser(user.getId());
        //获取角色权限
        List<Urls> roleUrls = getUrlsFromRole(user.getId());
        Set<String> limits = generateLimits(userUrls,roleUrls);
        for(String limit : limits) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(limit);
            authorities.add(grantedAuthority);
        }
        return authorities;
    }

    private Set<String> generateLimits(List<Urls> userUrls, List<Urls> roleUrls) {
        Set<String> results = new HashSet<String>();
        for(Urls tmp:userUrls){
            results.add(tmp.getLink_url());
        }
        for(Urls tmp:roleUrls){
            results.add(tmp.getLink_url());
        }
        return results;
    }

    private List<Urls> getUrlsFromRole(Integer userid) {
        return urlsDao.findByRole(userid);
    }

    private List<Urls> getUrlsFromUser(Integer userid) {
        return urlsDao.findByUserid(userid);
    }
}
