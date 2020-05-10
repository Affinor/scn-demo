package com.jin.demo.serviceuser;

import com.jin.demo.serviceuser.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@TestPropertySource("classpath:application.yml")
@SpringBootTest
class ServiceUserApplicationTests {

    @Autowired
    ApplicationContext applicationContext;



    @Test
    void contextLoads() {
        UserController userController = (UserController)applicationContext.getBean("userController");
        userController.login("123","456");
    }

}
