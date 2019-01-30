package com.cn.zm.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserUrls  implements Serializable {
    private static final long serialVersionUID = 8879714410481818086L;
    private Integer id;
    private Integer userid;
    private Integer urlsid;
    private Timestamp entry_date;
}
