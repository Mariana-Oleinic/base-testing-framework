package com.base.api.testing.framework.steps.catalog;

import com.base.api.testing.framework.service.client.CatalogClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CatalogSteps {

    private final CatalogClient catalog;

}
