package com.base.api.testing.framework.model.catalog;

import lombok.Data;

import java.util.List;

@Data
public class BreadCrumb {

    private String categoryId;
    private String seoToken;
    private List<String> parentCategoryIds;
    private List<String> fullPaths;
    private List<String> fullPathIds;
    private List<String> fullPathSeoTokens;
    private String fullUrl;
}
