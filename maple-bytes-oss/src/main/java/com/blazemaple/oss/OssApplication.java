package com.blazemaple.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author BlazeMaple
 * @description Oss服务启动类
 * @date 2024/1/25 3:53
 */
@SpringBootApplication
@ComponentScan("com.blazemaple")
public class OssApplication {

    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class);
    }
}
