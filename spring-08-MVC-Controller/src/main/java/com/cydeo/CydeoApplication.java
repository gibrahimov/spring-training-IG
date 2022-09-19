package com.cydeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = {AopAutoConfiguration.class})
/*
Exclusions:
-----------

    org.springframework.boot.autoconfigure.aop.AopAutoConfiguration

    i means since we excluded spring will not create beans for that class if yiu want you can dio yourself
 */
public class CydeoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CydeoApplication.class, args);
    }

}
