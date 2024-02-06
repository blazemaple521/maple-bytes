package com.blazemaple.oss.entity;

import lombok.Data;

/**
 * @author BlazeMaple
 * @description 文件类
 * @date 2024/1/25 4:11
 */
@Data
public class FileInfo {

    private String fileName;

    private Boolean directoryFlag;

    private String etag;
}
