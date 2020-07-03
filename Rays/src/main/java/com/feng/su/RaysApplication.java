package com.feng.su;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.feng.su.mapper")
@SpringBootApplication
public class RaysApplication {
        public static void main(String[] args) {
            SpringApplication.run(RaysApplication.class,args);
        }
    }
