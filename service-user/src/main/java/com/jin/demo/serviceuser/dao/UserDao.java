package com.jin.demo.serviceuser.dao;

import com.jin.demo.servicecommon.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangjin
 */
public interface UserDao extends JpaRepository<User,Integer> {
}
