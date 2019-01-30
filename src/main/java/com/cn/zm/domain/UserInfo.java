package com.cn.zm.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 7094004598646216788L;
    private Integer id;
    private String username;
    private String password;
    private String telephone;
    private Timestamp entry_date;
    private Integer isadmin;


}
