package com.base.api.testing.framework.model.catalog;

import com.base.api.testing.framework.model.catalog.enums.ResourceType;
import lombok.Data;

import java.util.List;

@Data
public class Category {

    private String categoryId;
    private ResourceType type;
    private String thumbnail;
    private List<ParentCategory> parentCategories;
    private List<String> childCategoryIds;
    private List<String> fullPaths;
    private List<String> fullPathIds;
    private List<String> fullPathSeoTokens;
    private String fullUrl;
    private String pageTitle;
    private String metaDescription;
    private boolean isTopCategory;
}
