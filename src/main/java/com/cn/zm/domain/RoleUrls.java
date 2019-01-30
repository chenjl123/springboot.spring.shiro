package com.cn.zm.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RoleUrls  implements Serializable {
    private static final long serialVersionUID = 7650256171843714524L;
    private Integer id;
    private Integer roleid;
    private Integer urlsid;
    private Timestamp entry_date;

}
