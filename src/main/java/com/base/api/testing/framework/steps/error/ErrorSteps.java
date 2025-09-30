package com.base.api.testing.framework.steps.error;

import com.base.api.testing.framework.error.ErrorResponse;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Component
public class ErrorSteps {

    @Step("Validate response status code")
    public void validateResponseStatusCode(Response response, int expectedStatus) {
        response.then().statusCode(expectedStatus);
    }

    @Step("Validate error response")
    public void validateErrorResponse(Response response, int expectedStatus, String expectedMessage) {
        ErrorResponse errorResponse = response
                .then()
                .statusCode(expectedStatus)
                .extract()
                .body().as(ErrorResponse.class);
        assertThat(errorResponse.getMessage()).as("Error message").isEqualTo(expectedMessage);
    }

    @Step("Validate error response")
    public void validateErrorResponseWithServiceErrorCode(Response response, int expectedStatus, String expectedServiceErrorCode, String expectedMessage) {
        ErrorResponse errorResponse = response
                .then()
                .statusCode(expectedStatus)
                .extract()
                .body().as(ErrorResponse.class);
        assertThat(errorResponse.getServiceErrorCode()).as("Service error code").isEqualTo(expectedServiceErrorCode);
        assertThat(errorResponse.getMessage()).as("Error message").isEqualTo(expectedMessage);
    }

    @Step("Validate error response")
    public void validateErrorResponseWithExtensions(Response response, int expectedStatus, ErrorResponse expectedErrorResponse) {
        ErrorResponse errorResponse = response
                .then()
                .statusCode(expectedStatus)
                .extract()
                .body().as(ErrorResponse.class);
        assertThat(errorResponse)
                .usingRecursiveComparison()
                .as("Error response must be as expected")
                .isEqualTo(expectedErrorResponse);
    }
}
