package com.base.api.testing.framework.error;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ErrorResponseProvider {

    public ErrorResponse searchValidationErrorResponse(String path, String value) {
        return ErrorResponse.builder()
                .serviceErrorCode("SEARCH_SERVICE_BAD_REQUEST")
                .message("Validation problem!")
                .extensions(List.of(Extension.builder()
                        .path(path)
                        .message("Invalid identifier provided! Value: '%s'.".formatted(value))
                        .build()))
                .build();
    }
}
