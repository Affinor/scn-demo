package com.jin.demo.serviceuser.service;

import com.jin.demo.servicecommon.pojo.User;

/**
 * @author wangjin
 */
public interface UserService {

    User login(User user);

    User register(User user);

    Boolean checkRegister(String uname);

    String selectEmail(String uname);

}
