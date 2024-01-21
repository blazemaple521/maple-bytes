package com.blazemaple.subject.common.enums;

import lombok.Getter;

/**
 * @description
 *
 * @author BlazeMaple
 * @date 2024/1/18 22:09
 */ 
@Getter
public enum ResultCodeEnum {

    SUCCESS(200,"成功"),
    FAIL(500,"失败");

    public int code;

    public String desc;

    ResultCodeEnum(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public static ResultCodeEnum getByCode(int codeVal){
        for(ResultCodeEnum resultCodeEnum : ResultCodeEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }

}
