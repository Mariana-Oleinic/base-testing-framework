package com.base.api.testing.framework.config;

import com.base.api.testing.framework.service.client.CatalogClient;
import com.base.api.testing.framework.service.client.SearchClient;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties({EnvironmentConfigurationProperties.class})
@RequiredArgsConstructor
public class EnvironmentConfiguration {

    private final EnvironmentConfigurationProperties serviceConfigurationProperties;

    @Bean
    public String catalogBaseUrl() {
        return serviceConfigurationProperties.getCatalog().getUrl();
    }

    @Bean
    public CatalogClient catalog(String catalogBaseUrl) {
        return new CatalogClient(catalogBaseUrl);
    }

    @Bean
    public String searchBaseUrl() {
        return serviceConfigurationProperties.getSearch().getUrl();
    }

    @Bean
    public SearchClient search(String searchBaseUrl) {
        return new SearchClient(searchBaseUrl);
    }

}
