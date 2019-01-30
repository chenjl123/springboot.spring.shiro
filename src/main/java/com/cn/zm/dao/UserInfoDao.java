package com.cn.zm.dao;

import java.util.List;

import com.cn.zm.domain.UserInfo;

public interface UserInfoDao {
    List<UserInfo> findAll();

    UserInfo findById(Integer userid);

    void delById(Integer userid);

    void saveUser(UserInfo user);

    void updateUser(UserInfo dbInfo);

    UserInfo findByUsername(String username);
}
