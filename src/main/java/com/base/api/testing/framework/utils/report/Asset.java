package com.base.api.testing.framework.utils.report;

public interface Asset {

    String CATALOG_EPIC = "Catalog";
    String SEARCH_EPIC = "Search";
    String COMPARISON_EPIC = "Catalog Comparison Tests";

    String PRODUCT_FEATURE = "Product";
    String CATEGORY_FEATURE = "Category";
    String SKU_FEATURE = "SKU";
    String BRAND_FEATURE = "Brand";

    // Catalog API
    String SAPD_XXXX_GET_BRANDS_SUGGESTIONS = "SAPD_XXXX Catalog API: Get all Brand suggestions";
    String SAPD_XXXX_GET_CATEGORIES = "SAPD_XXXX Catalog API: /categories";
    String SAPD_XXXX_GET_TOP_CATEGORIES = "SAPD_XXXX Catalog API: Get Top level categories.";
}
