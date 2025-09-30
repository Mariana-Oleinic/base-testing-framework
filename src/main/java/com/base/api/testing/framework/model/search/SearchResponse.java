package com.base.api.testing.framework.model.search;

import com.base.api.testing.framework.model.catalog.Product;
import lombok.Data;

import java.util.List;

@Data
public class SearchResponse {

    public List<Product> products;
}
