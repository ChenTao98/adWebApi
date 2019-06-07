package com.adweb.adweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.adweb.adweb.dao")
public class AdWebApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdWebApiApplication.class, args);
    }

}
