package com.base.api.testing.framework.catalog;

import com.base.api.testing.framework.BaseTest;
import com.base.api.testing.framework.config.TestDataConfigurationProperties;
import com.base.api.testing.framework.model.catalog.Category;
import com.base.api.testing.framework.steps.catalog.CategorySteps;
import com.base.api.testing.framework.steps.error.ErrorSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.base.api.testing.framework.utils.report.Asset.*;
import static com.base.api.testing.framework.utils.report.Tag.*;

@Epic(CATALOG_EPIC)
@Feature(CATEGORY_FEATURE)
@Story(SAPD_XXXX_GET_CATEGORIES)
@DisplayName("Get Categories from Catalog API")
@Tags({@Tag(UAT), @Tag(PROD), @Tag(CATALOG_CI)})
public class GetCategoriesTest extends BaseTest {

    @Autowired
    CategorySteps categorySteps;
    @Autowired
    ErrorSteps errorSteps;
    @Autowired
    TestDataConfigurationProperties testData;

    @Test
    @DisplayName("Catalog API return top categories")
    @Description("""
            Steps:
            1. Get top categories from catalog api
            2. Validate the response
            Expected result:
            - categories list is not empty
            - all received categories are top categories"""
    )
    public void serviceReturnsTopCategories() {
        List<Category> response = categorySteps.getTopCategories();
        categorySteps.validateTopCategoriesResponse(response);
    }

    @Test
    @DisplayName("Catalog API return category by category id")
    @Description("""
            Steps:
            1. Get category by categoryId from catalog core api
            2. Validate the response
            Expected result:
            - response code should be 200
            - category should not be null
            - category should contain all the required fields"""
    )
    public void serviceReturnsCategoryByCategoryId() {
        var categoryId = testData.getCategories().getDefaultCategory().getCategoryId();
        var request = categorySteps.getCategoryByCategoryId(categoryId);
        categorySteps.validateCategoryResponse(request, categoryId);
    }

    @Test
    @DisplayName("Catalog API return error 404 Not Found for non-existing categoryId")
    @Description("""
            Steps:
            1. Send a request to catalog core api with non-existing categoryId
            2. Validate the response
            Expected result:
            - service should return 404 Not Found
            - error message should contain correct service error code"""
    )
    public void serviceReturnsNotFoundForNonExistingCategoryId() {
        var nonExistingCategoryId = "0000000";
        var response = categorySteps.getCategoryResponse(nonExistingCategoryId);
        errorSteps.validateErrorResponseWithServiceErrorCode(response, HttpStatus.SC_NOT_FOUND,
                "CATALOG_SERVICE_CATEGORY_ID_NOT_FOUND",
                ("No category id found '%s'.").formatted(nonExistingCategoryId));
    }
}
