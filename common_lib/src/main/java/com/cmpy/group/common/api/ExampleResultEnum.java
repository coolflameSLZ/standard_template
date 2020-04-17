package com.cmpy.group.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.servlet.http.HttpServletResponse;

/**
 * 通用的返回码
 * 业务返回码不能放到这里面
 */
@Getter
@AllArgsConstructor
public enum ExampleResultEnum implements IResultEnum {


    SUCCESS(0, "OK"),
    SERVER_ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "未知异常"),
    UN_AUTHORIZED(HttpServletResponse.SC_UNAUTHORIZED, "权限不足"),
    RES_NOT_FOUND(HttpServletResponse.SC_NOT_FOUND, "缺少资源"),
    PARAM_MISS(HttpServletResponse.SC_BAD_REQUEST, "缺少必要参数"),
    PARAM_TYPE_ERROR(HttpServletResponse.SC_BAD_REQUEST, "参数类型错误"),
    PARAM_BIND_ERROR(HttpServletResponse.SC_BAD_REQUEST, "数据bind错误"),
    PARAM_VALID_ERROR(HttpServletResponse.SC_BAD_REQUEST, "参数校验失败");

    final int code;
    final String msg;

    @Override
    public Integer code() {
        return code;
    }

    @Override
    public String msg() {
        return msg;
    }

}
