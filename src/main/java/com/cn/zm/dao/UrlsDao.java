package com.cn.zm.dao;

import java.util.List;

import com.cn.zm.domain.Urls;

public interface UrlsDao {
    List<Urls> findByRole(Integer userid);

    List<Urls> findByUserid(Integer userid);
}
