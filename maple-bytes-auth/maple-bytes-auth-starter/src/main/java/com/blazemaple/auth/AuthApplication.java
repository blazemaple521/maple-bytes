package com.blazemaple.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author BlazeMaple
 * @description 认证服务启动类
 * @date 2024/1/29 13:55
 */
@SpringBootApplication
@ComponentScan("com.blazemaple")
@MapperScan("com.blazemaple.**.mapper")
public class AuthApplication {

    public static void main(String[] args) {
        // 启动认证服务
        SpringApplication.run(AuthApplication.class);
    }

}
