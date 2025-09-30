package com.base.api.testing.framework.service.client;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SearchClient {

    private String searchBaseUrl;
    private static final String PRODUCT_LIST_PATH = "/products/search";

    public Response searchProductsByKeyword(String keyword, int pageNumber, int pageSize) {
        return basicSpecification()
                .basePath(PRODUCT_LIST_PATH)
                .queryParam("q", keyword)
                .queryParam("pageNr", pageNumber)
                .queryParam("pageSize", pageSize)
                .when().get();
    }

    private RequestSpecification basicSpecification() {
        return RestAssured.given()
                .baseUri(searchBaseUrl)
                .contentType("application/json");
    }
}
