package com.base.api.testing.framework.error;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ErrorResponse {

    private String serviceErrorCode;
    private String message;
    private String path;
    private List<Extension> extensions;
}
