package com.adweb.adwebapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.adweb.adwebapi.dao")
public class AdWebApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdWebApiApplication.class, args);
    }

}
