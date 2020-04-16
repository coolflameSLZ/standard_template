package com.cmpy.group.common.aop;

import com.cmpy.group.common.env.EnvConfig;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 错误日志切面
 */
@Aspect
@Slf4j
public class SentryClientAspect {

    @Autowired
    EnvConfig envConfig;

    @Around("execution(* io.sentry.SentryClient.send*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        if (envConfig.isDebug()) {
            log.debug("debug模式不开启sentry");
            return;
        }
        joinPoint.proceed();
    }
}
