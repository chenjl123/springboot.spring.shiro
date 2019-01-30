package com.cn.zm.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cn.zm.dao.UserInfoDao;
import com.cn.zm.domain.UserInfo;

@Repository("userInfoDao")
public class UserInfoDaoImpl implements UserInfoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<UserInfo> findAll() {
        return jdbcTemplate.query("select * from user_info",new UserInfoRowMapper());
    }

    @Override
    public UserInfo findById(Integer userid) {
        return jdbcTemplate.query("select * from user_info where id=?",new Object[]{userid},new UserInfoRowMapper()).get(0);
    }

    @Override
    public void delById(Integer userid) {
        jdbcTemplate.update("DELETE from user_info where id=?",userid);
    }

    @Override
    public void saveUser(UserInfo user) {
        String sql ="insert into user_info(username,password,telephone,isadmin) values(?,?,?,?)";
        jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.getTelephone(),user.getIsadmin());
    }

    @Override
    public void updateUser(UserInfo dbInfo) {
        String sql="update user_info set username=?,telephone=?,isadmin=? where id=?";
        jdbcTemplate.update(sql,dbInfo.getUsername(),dbInfo.getTelephone(),dbInfo.getIsadmin(),dbInfo.getId());
    }

    @Override
    public UserInfo findByUsername(String username) {
        String sql = "select * from user_info where username=? or telephone=?";
        List<UserInfo> results = jdbcTemplate.query(sql,new Object[]{username,username},new UserInfoRowMapper());
        return results.size()>0?results.get(0):null;
    }

    private final class UserInfoRowMapper implements RowMapper<UserInfo>{

        @Override
        public UserInfo mapRow(ResultSet rs, int i) throws SQLException {
            UserInfo result = new UserInfo();
            result.setEntry_date(rs.getTimestamp("entry_date"));
            result.setId(rs.getInt("id"));
            result.setPassword(rs.getString("password"));
            result.setTelephone(rs.getString("telephone"));
            result.setUsername(rs.getString("username"));
            result.setIsadmin(rs.getInt("isadmin"));
            return result;
        }
    }

}
