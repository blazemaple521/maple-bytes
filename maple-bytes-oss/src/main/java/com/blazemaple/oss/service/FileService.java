package com.blazemaple.oss.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author BlazeMaple
 * @description 文件服务
 * @date 2024/1/25 4:16
 */
public interface FileService {

    /**
     * 列出所有的bucket
     * @return bucket列表
     */
    List<String> getAllBucket();

    String getUrl(String bucketName, String objectName);

    String uploadFile(MultipartFile uploadFile, String bucket, String objectName);
}
