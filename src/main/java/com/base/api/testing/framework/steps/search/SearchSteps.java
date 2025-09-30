package com.base.api.testing.framework.steps.search;

import com.base.api.testing.framework.service.client.SearchClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SearchSteps {

    private final SearchClient search;

}
