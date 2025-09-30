package com.base.api.testing.framework.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "testdata")
public class TestDataConfigurationProperties {

    private ProductsData products;
    private SkusData skus;
    private CategoriesData categories;

    @Data
    public static class ProductsData {
        private Product defaultProduct;
        private Product warranty;
        private Product giftCard;
        private Product clearance;
        private Product nonVariant;
        private Product multiVariant;
        private Product nonExisting;
    }

    @Data
    public static class Product {
        private String partNumber;
        private String seoUrl;
        private List<String> skus;
        private LocationsData locations;
    }

    @Data
    public static class SkusData {
        private Sku defaultSku;
        private Sku warranty;
        private Sku clearance;
        private Sku giftCard;
        private Sku promotion;
        private Sku nonVariant;
        private Sku multiVariant;
        private Sku nonExisting;
    }

    @Data
    public static class Sku {
        private String partNumber;
        private String seoToken;
    }

    @Data
    public static class CategoriesData {
        private Category defaultCategory;
        private Category withNoChildren;
        private Category withSingleChild;
        private Category withMultipleChildren;
        private Category withNoParents;
        private Category withSingleParent;
        private Category withMultipleParents;
    }

    @Data
    public static class Category {
        private String categoryId;
        private String categoryName;
    }

    @Data
    public static class LocationsData {
        private Location defaultLocation;
        private Location alternativeLocation;
    }

    @Data
    public static class Location {
        private String storeId;
        private String zoneId;
        private String zipCode;
    }

}
