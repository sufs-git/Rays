package com.feng.su;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.feng.su.mapper")
@SpringBootApplication
public class RasyApplication {
        public static void main(String[] args) {
            SpringApplication.run(RasyApplication.class,args);
        }
    }
