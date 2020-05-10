package com.jin.demo.serviceuser.controller;

import com.jin.demo.servicecommon.pojo.User;
import com.jin.demo.serviceuser.service.CodeFeignClient;
import com.jin.demo.serviceuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author wangjin
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    CodeFeignClient codeFeignClient;

    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 登陆
     * @return
     */
    @GetMapping("/login")
    public String login(String email, String password){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        User login = userService.login(user);
        if (null != login){
            String token = UUID.randomUUID().toString();
            redisTemplate.opsForValue().set(token,email,30, TimeUnit.MINUTES);
        }
        return "恭喜登录成功:"+(null != login);
    }

    /**
     * 注册
     * @return
     */
    @GetMapping("/register")
    public String register(String email, String password, HttpServletResponse response){
        /*if(checkRegister(email)) {
            return "fail"; // 已经注册过
        }*/
        // 保存用户名+密码
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userService.register(user);
        // 注册成功，颁发token令牌，存入数据库并写入cookie，重定向到欢迎页
        String token = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(token,email,30, TimeUnit.MINUTES);
        Cookie cookie = new Cookie("login_token",token);
        cookie.setPath("/");
        response.addCookie(cookie);
        Cookie emailCookie = new Cookie("login_email",email);
        emailCookie.setPath("/");
        response.addCookie(emailCookie);
        return "注册成功:"+token;
    }

    /**
     * 检查用户是否注册
     * @return
     */
    @GetMapping("/checkRegister")
    public String checkRegister(String email){
        return "是否注册:"+userService.checkRegister(email);
    }

    /**
     * 查询用户登陆邮箱
     * @return
     */
    @GetMapping("/selectEmail")
    public String selectEmail(String token){
        return "token是否有效:"+token+":"+ (null != redisTemplate.opsForValue().get(token));
    }

}
