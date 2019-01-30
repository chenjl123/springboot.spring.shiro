package com.cn.zm.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Role implements Serializable{
    private static final long serialVersionUID = -7771353569883890210L;
    private Integer id;
    private String name;
    private Timestamp entry_date;
}
