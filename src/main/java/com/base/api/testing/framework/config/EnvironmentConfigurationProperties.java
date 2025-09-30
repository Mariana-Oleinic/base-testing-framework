package com.base.api.testing.framework.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "service")
public class EnvironmentConfigurationProperties {

    private ServiceProperties catalog;
    private ServiceProperties search;

    @Data
    public static class ServiceProperties {
        private String url;
        private String token;
    }
}
