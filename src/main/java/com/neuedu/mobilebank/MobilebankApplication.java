package com.neuedu.mobilebank;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.neuedu.mobilebank.mapper")
public class MobilebankApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobilebankApplication.class, args);
    }

}
