package com.base.api.testing.framework.service.client;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CatalogClient {

    private String catalogCoreStubBaseUrl;
    private static final String PRODUCTS_PART_NUMBER_PATH = "/products/{partNumber}";
    private static final String PRODUCTS_PATH = "/products";
    private static final String CATEGORIES_PATH = "/categories";
    private static final String CATEGORIES_CATEGORY_ID_PATH = "/categories/{categoryId}";
    private static final String CATEGORIES_PARENT_CATEGORY_ID_PATH = "/categories/children/{parentCategoryId}";
    private static final String TOP_CATEGORIES_PATH = "/top-categories";
    private static final String BRANDS_PATH = "/brands";

    public Response getProduct(String partNumber, boolean isArs) {
        if (isArs) {
            return basicSpecification()
                    .basePath(PRODUCTS_PART_NUMBER_PATH)
                    .header(new Header("env", "auth"))
                    .pathParam("partNumber", partNumber)
                    .when().get();
        } else {
            return basicSpecification()
                    .basePath(PRODUCTS_PART_NUMBER_PATH)
                    .pathParam("partNumber", partNumber)
                    .when().get();
        }
    }

    public Response getProducts(boolean isArs, String... partNumbers) {
        RequestSpecification requestSpec;
        if (isArs) {
            requestSpec = basicSpecification()
                    .basePath(PRODUCTS_PATH)
                    .header(new Header("env", "auth"));
        } else {
            requestSpec = basicSpecification()
                    .basePath(PRODUCTS_PATH);
        }


        if (partNumbers.length > 0) {
            String partNumbersParam = String.join(",", partNumbers);
            requestSpec = requestSpec.queryParam("partNumbers", partNumbersParam);
        }

        return requestSpec.when().get();
    }

    public Response getCategories(boolean isArs, String... categoryIds) {
        RequestSpecification requestSpec;
        if (isArs) {
            requestSpec = basicSpecification()
                    .basePath(CATEGORIES_PATH)
                    .header(new Header("env", "auth"));
        } else {
            requestSpec = basicSpecification()
                    .basePath(CATEGORIES_PATH);
        }

        if (categoryIds.length > 0) {
            String skuIdsParam = String.join(",", categoryIds);
            requestSpec = requestSpec.queryParam("categoryIds", skuIdsParam);
        }

        return requestSpec.when().get();
    }

    public Response getCategoryById(String categoryId, boolean isArs) {
        if (isArs) {
            return basicSpecification()
                    .basePath(CATEGORIES_CATEGORY_ID_PATH)
                    .header(new Header("env", "auth"))
                    .pathParam("categoryId", categoryId)
                    .when().get();
        } else {
            return basicSpecification()
                    .basePath(CATEGORIES_CATEGORY_ID_PATH)
                    .pathParam("categoryId", categoryId)
                    .when().get();
        }
    }

    public Response getChildCategories(String parentCategoryId, boolean isArs) {
        if (isArs) {
            return basicSpecification()
                    .basePath(CATEGORIES_PARENT_CATEGORY_ID_PATH)
                    .header(new Header("env", "auth"))
                    .pathParam("parentCategoryId", parentCategoryId)
                    .when().get();
        } else {
            return basicSpecification()
                    .basePath(CATEGORIES_PARENT_CATEGORY_ID_PATH)
                    .pathParam("parentCategoryId", parentCategoryId)
                    .when().get();
        }
    }

    public Response getTopCategories(boolean isArs) {
        if (isArs) {
            return basicSpecification()
                    .basePath(TOP_CATEGORIES_PATH)
                    .header(new Header("env", "auth"))
                    .when().get();
        } else {
            return basicSpecification()
                    .basePath(TOP_CATEGORIES_PATH)
                    .when().get();
        }
    }

    public Response getBrands(boolean isArs) {
        if (isArs) {
            return basicSpecification()
                    .basePath(BRANDS_PATH)
                    .header(new Header("env", "auth"))
                    .when().get();
        } else {
            return basicSpecification()
                    .basePath(BRANDS_PATH)
                    .when().get();
        }
    }

    private RequestSpecification basicSpecification() {
        return RestAssured.given()
                .baseUri(catalogCoreStubBaseUrl)
                .contentType("application/json");
    }
}
