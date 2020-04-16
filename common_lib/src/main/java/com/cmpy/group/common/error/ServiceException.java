package com.cmpy.group.common.error;

import com.cmpy.group.common.api.CommonResultEnum;
import com.cmpy.group.common.api.IResultEnum;
import lombok.Data;

/**
 * Business Service Exception
 *
 * @author william
 */
@Data
public class ServiceException extends RuntimeException {

    private final IResultEnum getResultEnum;

    public ServiceException(IResultEnum getResultEnum) {
        super(getResultEnum.msg());
        this.getResultEnum = getResultEnum;
    }

    public ServiceException(IResultEnum resultCodeEnum, String msg) {
        super(msg);
        this.getResultEnum = resultCodeEnum;
    }

    public ServiceException(IResultEnum resultCodeEnum, Throwable cause) {
        super(cause);
        this.getResultEnum = resultCodeEnum;
    }

    public ServiceException(String msg, Throwable cause) {
        super(msg, cause);
        this.getResultEnum = CommonResultEnum.SERVER_ERROR;
    }

    /**
     * 重写fillinStackTrace方法，
     * 不打印调用栈，性能更好
     *
     * @return Throwable
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    public Throwable doFillInStackTrace() {
        return super.fillInStackTrace();
    }
}
