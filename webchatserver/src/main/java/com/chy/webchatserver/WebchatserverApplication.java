package com.chy.webchatserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chy.webchatserver.mapper")
public class WebchatserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebchatserverApplication.class, args);
    }

}
