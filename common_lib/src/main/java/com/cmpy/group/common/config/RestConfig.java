package com.cmpy.group.common.config;

import com.cmpy.group.common.aop.SentryClientAspect;
import com.cmpy.group.common.error.GlobalExceptionTranslator;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Use this common config for Rest API
 */
@Configuration
@Import(value = {CommonConfig.class, SentryClientAspect.class, GlobalExceptionTranslator.class})
public class RestConfig {
}
