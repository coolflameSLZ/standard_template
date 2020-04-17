package com.cmpy.group.common.constant;

import cn.hutool.core.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DeleteStatusEnum {


    /**
     * 未删除
     */
    NORMAL(0, "未删除"),
    /**
     * 已删除
     */
    DELETE(1, "已删除"),


    ;
    // 数据库中的值
    private final Integer code;
    // 中文描述
    private final String cnName;


    @JsonCreator
    public static DeleteStatusEnum fromStr(String enumString) {
        return EnumUtil.fromString(DeleteStatusEnum.class, enumString, null);
    }

    @JsonCreator
    public static DeleteStatusEnum fromNum(Integer i) {
        if (i == null) return null;

        switch (i) {

            case 0:
                return NORMAL;
            case 1:
                return DELETE;

            default:
                return null;
        }
    }
}
