package com.base.api.testing.framework.model.catalog;

import com.base.api.testing.framework.model.catalog.enums.ResourceType;
import lombok.Data;

import java.util.List;

@Data
public class Product {

    private String partNumber;
    private ResourceType type;
    private List<BreadCrumb> categories;
    private String title;
    private String thumbnail;
    private List<String> skuIds;
    private List<Sku> skus;
    private String languageId;
}
