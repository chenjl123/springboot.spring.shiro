package com.cn.zm.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cn.zm.dao.UrlsDao;
import com.cn.zm.domain.Urls;

@Repository("urlsDao")
public class UrlsDaoImpl implements UrlsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Urls> findByRole(Integer userid) {
        String sql = "select t3.* from (select t1.urlsid " +
                "from role_urls t1 join user_role t2 " +
                "on t1.roleid=t2.roleid " +
                "where t2.userid=?) t4 join urls t3 on t4.urlsid=t3.id";
        return jdbcTemplate.query(sql,new Object[]{userid},new UrlsRowMapper());
    }

    @Override
    public List<Urls> findByUserid(Integer userid) {
        String sql = "select t1.* from user_urls t2 join urls t1 " +
                "on t1.id=t2.urlsid where t2.userid=?";
        return jdbcTemplate.query(sql,new Object[]{userid},new UrlsRowMapper());
    }

    final class UrlsRowMapper implements RowMapper<Urls>{

        @Override
        public Urls mapRow(ResultSet rs, int i) throws SQLException {
            Urls result = new Urls();
            result.setId(rs.getInt("id"));
            result.setEntry_date(rs.getTimestamp("entry_date"));
            result.setLink_url(rs.getString("link_url"));
            result.setName(rs.getString("name"));
            return result;
        }
    }
}
