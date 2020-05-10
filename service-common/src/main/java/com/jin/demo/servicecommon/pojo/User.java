package com.jin.demo.servicecommon.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author wangjin
 */
@Data
@Entity
@Table(name="t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uname;
    private Integer age;
    private String password;
    private String email;
}
