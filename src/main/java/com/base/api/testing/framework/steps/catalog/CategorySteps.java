package com.base.api.testing.framework.steps.catalog;

import com.base.api.testing.framework.model.catalog.Category;
import com.base.api.testing.framework.service.client.CatalogClient;
import io.qameta.allure.Step;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.springframework.stereotype.Component;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@Component
@RequiredArgsConstructor
public class CategorySteps {

    private final CatalogClient catalogCore;

    @Step("Get top categories")
    public List<Category> getTopCategories() {
        return getTopCategories(false);
    }

    @Step("Get top categories")
    public List<Category> getTopCategories(boolean isTop) {
        return catalogCore.getTopCategories(isTop)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .as(new TypeRef<>() {
                });
    }

    @Step("Validate top categories response")
    public void validateTopCategoriesResponse(List<Category> categories) {
        assertThat(categories).as("Categories should not be empty").isNotEmpty();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(categories).map(Category::getCategoryId)
                .as("categoryId should not be null for all categories")
                .doesNotContainNull();
        softly.assertThat(categories).map(Category::isTopCategory)
                .as("isTopCategory should be true for all categories").containsOnly(true);
        softly.assertAll();
    }

    @Step("Get category by categoryId")
    public Category getCategoryByCategoryId(String categoryId) {
        return getCategoryByCategoryId(categoryId, false);
    }

    @Step("Get category by categoryId")
    public Category getCategoryByCategoryId(String categoryId, boolean isArs) {
        return catalogCore.getCategoryById(categoryId, isArs)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body().as(Category.class);
    }

    @Step("Get category by categoryId and return full response")
    public Response getCategoryResponse(String categoryId) {
        return catalogCore.getCategoryById(categoryId, false);
    }

    @Step("Get categories by categoryIds")
    public List<Category> getCategories(String... categoryIds) {
        return getCategories(false, categoryIds);
    }

    @Step("Get categories by categoryIds")
    public List<Category> getCategories(boolean isArs, String... categoryIds) {
        return catalogCore.getCategories(isArs, categoryIds)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .as(new TypeRef<>() {
                });
    }

    @Step("Get categories by categoryIds and return full response")
    public Response getCategoriesResponse(String... categoryIds) {
        return catalogCore.getCategories(false, categoryIds);
    }

    @Step("Validate get category by categoryId response")
    public void validateCategoryResponse(Category response, String categoryId) {
        SoftAssertions softly = new SoftAssertions();
        validateCategoryResponse(response, categoryId, softly);
        softly.assertAll();
    }

    public void validateCategoryResponse(Category category, String categoryId, SoftAssertions softly) {
        assertThat(category).as("Category should not be null").isNotNull();
        softly.assertThat(category.getCategoryId()).as("categoryId")
                .isEqualTo(categoryId);
        validateCategoryResponse(category, softly);
    }

    public void validateCategoryResponse(Category category, SoftAssertions softly) {
        assertThat(category).as("Category should not be null").isNotNull();
        softly.assertThat(category.getCategoryId()).as("categoryId")
                .isNotEmpty();
        softly.assertThat(category.getThumbnail()).as("thumbnail")
                .isNotEmpty();
        softly.assertThat(category.isTopCategory()).as("topCategory")
                .isNotNull();
        softly.assertThat(category.getFullPathIds()).as("fullPathIds")
                .isNotNull();
        softly.assertThat(category.getFullPaths()).as("fullPaths")
                .isNotNull();
        softly.assertThat(category.getParentCategories()).as("parentCategories")
                .isNotNull();
        softly.assertThat(category.getChildCategoryIds()).as("childCategoryIds")
                .isNotNull();
        softly.assertAll();
    }
}