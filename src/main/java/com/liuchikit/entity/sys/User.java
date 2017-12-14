package com.liuchikit.entity.sys;

import com.liuchikit.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Table(name = "TB_USER")
public class User extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 288644676516623192L;

    private String account;

    private String name;

    private String password;

    private Date birth;

    private String email;

    private String phone;

    private Long deptId;

    private Long posId;
}
