package com.jin.demo.serviceuser.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wangjin
 */
@FeignClient(value = "service-code")
@RequestMapping("/api/code")
public interface CodeFeignClient {

    @GetMapping("/checkCode/{email}/{code}")
    public String validateCode(@PathVariable("email") String email,@PathVariable("code") String code);
}
