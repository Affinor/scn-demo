package com.jin.demo.serviceemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangjin
 */
@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("/sendEmail/{email}/{code}")
    public String sendEmail(@PathVariable("email") String email, @PathVariable("code") String code){
        return emailService.sendEmail(email,code);
    }
}
