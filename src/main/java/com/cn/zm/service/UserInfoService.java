package com.cn.zm.service;

import java.util.List;

import com.cn.zm.domain.UserInfo;

/**
 * 
 * @author Administrator
 *
 */
public interface UserInfoService {
    List<UserInfo> findAll();

    UserInfo findById(Integer userid);

    void delById(Integer userid);

    void saveUser(UserInfo user);

    void updateUser(UserInfo dbInfo);

    UserInfo findByUsername(String username);
}
