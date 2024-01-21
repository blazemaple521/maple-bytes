package com.blazemaple.subject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author BlazeMaple
 * @description 刷题微服务启动类
 * @date 2024/1/18 17:29
 */
@SpringBootApplication
@ComponentScan("com.blazemaple")
@MapperScan("com.blazemaple.**.mapper")
public class SubjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class);
    }
}
