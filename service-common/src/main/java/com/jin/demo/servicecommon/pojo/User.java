package com.jin.demo.servicecommon.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wangjin
 */
@Data
@Entity
@Table(name="t_user")
public class User {
    @Id
    private Integer id;
    private String uname;
    private Integer age;
    private String password;
    private String email;
}
