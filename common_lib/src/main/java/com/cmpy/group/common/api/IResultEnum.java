package com.cmpy.group.common.api;

/**
 * 返回值枚举通用接口
 */
public interface IResultEnum {

    /**
     * @return 返回错误码
     */
    Integer code();

    /**
     * @return 返回错误描述
     */
    String msg();
}
