package com.base.api.testing.framework.error;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Extension {

    private String path;
    private String message;
}
