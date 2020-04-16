package com.cmpy.group.common.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static com.cmpy.group.common.api.CommonResultEnum.SUCCESS;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> implements Serializable {
    private static final int FAILURE_CODE = -1;

    @JsonAlias({"code", "ret"})
    private int code = SUCCESS.code;
    @JsonAlias({"msg", "message"})
    private String msg = SUCCESS.msg;
    @JsonAlias({"result", "output", "data"})
    private T result;


    // 成功
    public static <T> CommonResponse<T> success() {
        return new CommonResponse(SUCCESS.code, SUCCESS.msg, null);
    }

    public static <T> CommonResponse<T> success(T result) {
        return new CommonResponse(SUCCESS.code, SUCCESS.msg, result);
    }

    // 失败
    public static <T> CommonResponse<T> error(IResultEnum resultEnum) {
        return new CommonResponse(resultEnum.code(), resultEnum.msg(), null);
    }

    public static <T> CommonResponse<T> error(IResultEnum resultEnum, T result) {
        return new CommonResponse(resultEnum.code(), resultEnum.msg(), result);
    }


}
