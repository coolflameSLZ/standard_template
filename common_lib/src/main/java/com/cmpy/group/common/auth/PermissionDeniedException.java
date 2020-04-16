package com.cmpy.group.common.auth;

import com.cmpy.group.common.api.CommonResultEnum;
import com.cmpy.group.common.api.IResultEnum;
import lombok.Getter;

public class PermissionDeniedException extends RuntimeException {

    @Getter
    private final IResultEnum resultEnum;

    public PermissionDeniedException(String message) {
        super(message);
        this.resultEnum = CommonResultEnum.UN_AUTHORIZED;
    }

    public PermissionDeniedException(IResultEnum resultEnum) {
        super(resultEnum.msg());
        this.resultEnum = resultEnum;
    }

    public PermissionDeniedException(IResultEnum resultEnum, Throwable cause) {
        super(cause);
        this.resultEnum = resultEnum;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    public Throwable doFillInStackTrace() {
        return super.fillInStackTrace();
    }

}
