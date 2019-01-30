package com.cn.zm.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Urls  implements Serializable {
    private static final long serialVersionUID = 5482862730675423904L;
    private Integer id;
    private String name;
    private String link_url;
    private Timestamp entry_date;

}
