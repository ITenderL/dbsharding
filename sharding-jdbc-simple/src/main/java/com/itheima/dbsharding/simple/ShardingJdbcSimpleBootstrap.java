package com.itheima.dbsharding.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = SpringBootConfiguration.class)
@SpringBootApplication
public class ShardingJdbcSimpleBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcSimpleBootstrap.class, args);
    }

}
