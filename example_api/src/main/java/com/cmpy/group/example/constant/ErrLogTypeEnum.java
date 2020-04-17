package com.cmpy.group.example.constant;

import cn.hutool.core.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrLogTypeEnum {

    /**
     * 系统升级日志
     */
    SYS_LOG(1, "系统升级日志"),

    /**
     * app运行日志
     */
    APP_LOG(2, "app运行日志"),


    ;

    // 数据库中的值
    private final Integer code;
    // 中文描述
    private final String cnName;


    @JsonCreator
    public static ErrLogTypeEnum fromStr(String enumString) {
        return EnumUtil.fromString(ErrLogTypeEnum.class, enumString, null);
    }

    @JsonCreator
    public static ErrLogTypeEnum fromNum(Integer i) {
        if (i == null) return null;

        switch (i) {

            case 0:
                return SYS_LOG;
            case 1:
                return APP_LOG;

            default:
                return null;
        }
    }


}
