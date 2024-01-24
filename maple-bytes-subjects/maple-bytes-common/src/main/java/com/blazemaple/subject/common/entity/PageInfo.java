package com.blazemaple.subject.common.entity;

import lombok.Data;

/**
 * @author BlazeMaple
 * @description 分页请求实体
 * @date 2024/1/23 15:05
 */
@Data
public class PageInfo {

    private Integer pageNo = 1;

    private Integer pageSize = 20;

    public Integer getPageNo() {
        if (pageNo == null || pageNo < 1) {
            return 1;
        }
        return pageNo;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize < 1 || pageSize > Integer.MAX_VALUE) {
            return 20;
        }
        return pageSize;
    }
}
