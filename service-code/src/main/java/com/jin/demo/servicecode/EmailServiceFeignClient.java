package com.jin.demo.servicecode;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wangjin
 */
@FeignClient(value = "service-email")
@RequestMapping("/api/email")
public interface EmailServiceFeignClient {

    @RequestMapping("/sendEmail/{email}/{code}")
    public String sendEmail(@PathVariable("email") String email, @PathVariable("code") String code);
}
