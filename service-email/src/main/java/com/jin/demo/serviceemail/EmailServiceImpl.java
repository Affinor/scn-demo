package com.jin.demo.serviceemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public String sendEmail(String email, String code) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("jin_obj@sina.com");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("验证码");
        simpleMailMessage.setText(code);
        javaMailSender.send(simpleMailMessage);
        return "send email success:"+email+"===>>code:"+code;
    }
}
