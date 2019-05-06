package com.chy.webchatserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.chy.webchatserver.mapper")
@EnableCaching
public class WebchatserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebchatserverApplication.class, args);
    }

}
