package com.cn.zm.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserRole  implements Serializable {
    private static final long serialVersionUID = -5855827527479872315L;
    private Integer id;
    private Integer userid;
    private Integer roleid;
    private Timestamp entry_date;
   
}
