package com.cmpy.group.common.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties(prefix = "biz.common")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonProps {
    @NotBlank
    private String sentryDsn;
    @NotBlank
    // DeployEnvVar is set by Kubernetes during a new deployment so we can identify the code version
    private String deployEnv;
}

