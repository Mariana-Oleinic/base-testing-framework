package com.base.api.testing.framework.model.catalog;

import lombok.Data;

import java.util.List;

@Data
public class CatalogResponse {

    public List<Product> products;
}
