package com.jin.demo.serviceuser.service;

import com.jin.demo.servicecommon.pojo.User;
import com.jin.demo.serviceuser.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 * @author wangjin
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.findOne(Example.of(user)).get();
    }

    @Override
    public User register(User user) {
        return userDao.saveAndFlush(user);
    }

    @Override
    public Boolean checkRegister(String uname) {
        User user = new User();
        user.setEmail(uname);
        return userDao.exists(Example.of(user));
    }

    @Override
    public String selectEmail(String uname) {
        User user = new User();
        user.setUname(uname);
        return userDao.findOne(Example.of(user)).get().getEmail();
    }
}
