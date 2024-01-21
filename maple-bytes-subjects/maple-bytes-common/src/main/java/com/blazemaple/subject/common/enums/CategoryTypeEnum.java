package com.blazemaple.subject.common.enums;

import lombok.Getter;

/**
 * @description 分类类型枚举
 *
 * @author BlazeMaple
 * @date 2024/1/21 13:57
 */
@Getter
public enum CategoryTypeEnum {

    PRIMARY(1,"岗位大类"),
    SECOND(2,"二级分类");

    public int code;

    public String desc;

    CategoryTypeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static CategoryTypeEnum getByCode(int codeVal){
        for(CategoryTypeEnum resultCodeEnum : CategoryTypeEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }

}
