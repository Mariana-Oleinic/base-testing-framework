package com.base.api.testing.framework.config;

import com.github.javafaker.Faker;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.base.api.testing.framework")
@EnableConfigurationProperties({TestDataConfigurationProperties.class})
public class TestConfiguration {

    @Bean
    public Faker faker() {
        return new Faker();
    }

}
