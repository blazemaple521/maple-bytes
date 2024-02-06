package com.blazemaple.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/2/1 20:07
 */
@SpringBootApplication
@ComponentScan("com.blazemaple")
public class WxApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxApplication.class);
    }

}
