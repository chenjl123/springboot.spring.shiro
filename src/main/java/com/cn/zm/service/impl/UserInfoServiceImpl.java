package com.cn.zm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.zm.dao.UserInfoDao;
import com.cn.zm.domain.UserInfo;
import com.cn.zm.service.UserInfoService;

/**
 * 
 * @author Administrator
 *
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public List<UserInfo> findAll() {
        return userInfoDao.findAll();
    }

    @Override
    public UserInfo findById(Integer userid) {
        return userInfoDao.findById(userid);
    }

    @Override
    public void delById(Integer userid) {
        userInfoDao.delById(userid);
    }

    @Override
    public void saveUser(UserInfo user) {
        userInfoDao.saveUser(user);
    }

    @Override
    public void updateUser(UserInfo dbInfo) {
        userInfoDao.updateUser(dbInfo);
    }

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoDao.findByUsername(username);
    }
}
