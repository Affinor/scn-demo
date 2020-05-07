package com.jin.demo.servicecode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author wangjin
 */
@RestController
@RequestMapping("/api/code")
public class CodeController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    EmailServiceFeignClient emailServiceFeignClient;

    @GetMapping("/createCode")
    public String createCode(String name){
        //生成验证码
        String code = String.valueOf(new Random().nextInt());
        //验证码存放10分钟
        redisTemplate.opsForValue().set(name,code,10, TimeUnit.MINUTES);
        //发送邮件
        String result = emailServiceFeignClient.sendEmail(name, code);
        return "createCode:"+name+"===>>result:"+result;
    }

    @GetMapping("/checkCode")
    public Boolean checkCode(String name, String code){
        Object o = redisTemplate.opsForValue().get(name);
        return code.equals(o);
    }
}
