package com.jin.demo.serviceuser.controller;

import com.jin.demo.servicecommon.pojo.User;
import com.jin.demo.serviceuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangjin
 */
@RestController(value = "/api/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 登陆
     * @return
     */
    @GetMapping("/login")
    public String login(String email, String password){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userService.login(user);
        return "success";
    }

    /**
     * 注册
     * @return
     */
    @GetMapping("/register/{email}/{password}/${name}/${age}")
    public String register(@PathVariable("email") String email,
                           @PathVariable("password") String password,
                           @PathVariable("name") String name,
                           @PathVariable("age") Integer age){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setUname(name);
        user.setAge(age);
        userService.register(user);
        return "success";
    }

    /**
     * 检查用户是否注册
     * @return
     */
    @GetMapping("/checkRegister/${email}")
    public String checkRegister(@PathVariable("email") String email){
        Boolean checkRegister = userService.checkRegister(email);
        return "success:"+checkRegister;
    }

    /**
     * 查询用户登陆邮箱
     * @return
     */
    @GetMapping("/selectEmail/${name}")
    public String selectEmail(@PathVariable("name") String name){
        String selectEmail = userService.selectEmail(name);
        return "success:"+selectEmail;
    }

}
