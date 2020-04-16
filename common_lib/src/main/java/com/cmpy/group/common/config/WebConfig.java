package com.cmpy.group.common.config;

import com.cmpy.group.common.aop.SentryClientAspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Use this common config for Web App
 */
@Configuration
@Import(value = {CommonConfig.class, SentryClientAspect.class,})
public class WebConfig {
}
