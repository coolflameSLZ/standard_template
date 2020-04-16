package com.cmpy.group.common.error;

import com.cmpy.group.common.api.CommonResponse;
import com.cmpy.group.common.api.IResultEnum;
import com.cmpy.group.common.auth.PermissionDeniedException;
import com.github.structlog4j.ILogger;
import com.github.structlog4j.SLoggerFactory;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

import static com.cmpy.group.common.api.CommonResultEnum.*;

@RestControllerAdvice
public class GlobalExceptionTranslator {

    static final ILogger logger = SLoggerFactory.getLogger(GlobalExceptionTranslator.class);

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public CommonResponse<String> handleError(MissingServletRequestParameterException e) {
        logger.warn("Missing Request Parameter", e);
        String message = String.format("Missing Request Parameter: %s", e.getParameterName());
        return CommonResponse.error(PARAM_MISS, message);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public CommonResponse handleError(MethodArgumentTypeMismatchException e) {
        logger.warn("Method Argument Type Mismatch", e);
        String message = String.format("Method Argument Type Mismatch: %s", e.getName());
        return CommonResponse.error(PARAM_TYPE_ERROR, message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResponse handleError(MethodArgumentNotValidException e) {
        logger.warn("Method Argument Not Valid", e);
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String message = String.format("%s:%s", error.getField(), error.getDefaultMessage());
        return CommonResponse.error(PARAM_VALID_ERROR, message);
    }

    @ExceptionHandler(BindException.class)
    public CommonResponse handleError(BindException e) {
        logger.warn("Bind Exception", e);
        FieldError error = e.getFieldError();
        String message = String.format("%s:%s", error.getField(), error.getDefaultMessage());
        return CommonResponse.error(PARAM_BIND_ERROR, message);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public CommonResponse handleError(ConstraintViolationException e) {
        logger.warn("Constraint Violation", e);
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String path = ((PathImpl) violation.getPropertyPath()).getLeafNode().getName();
        String message = String.format("%s:%s", path, violation.getMessage());
        return CommonResponse.error(PARAM_VALID_ERROR, message);
    }


    @ExceptionHandler(ServiceException.class)
    public CommonResponse handleError(ServiceException e) {
        logger.error("业务异常", e);
        IResultEnum resultCodeEnum = e.getGetResultEnum();
        return CommonResponse.error(resultCodeEnum);
    }

    @ExceptionHandler(PermissionDeniedException.class)
    public CommonResponse handleError(PermissionDeniedException e) {
        logger.error("Permission Denied", e);

        IResultEnum resultCodeEnum = e.getResultEnum();
        return CommonResponse.error(resultCodeEnum);
    }

    @ExceptionHandler(Throwable.class)
    public CommonResponse handleError(Throwable e) {
        logger.error("服务器异常", e);

        return CommonResponse.error(SERVER_ERROR);
    }
}
