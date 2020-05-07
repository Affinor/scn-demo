package com.jin.demo.eurekacenter2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaCenter2Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaCenter2Application.class, args);
    }

}
