package com.blazemaple.oss.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author BlazeMaple
 * @description Minio配置管理
 * @date 2024/1/25 3:56
 */
@Configuration
public class MinioConfig {

    /**
     * minio服务地址
     */
    @Value("${minio.url}")
    private String url;

    /**
     * minio账户
     */
    @Value("${minio.accessKey}")
    private String accessKey;

    /**
     * minio密码
     */
    @Value("${minio.secretKey}")
    private String secretKey;


    /**
     * 获取minio客户端
     *
     * @return MinioClient
     */
    @Bean
    public MinioClient getMinioClient() {
        return MinioClient.builder()
            .endpoint(url)
            .credentials(accessKey, secretKey)
            .build();
    }

}
