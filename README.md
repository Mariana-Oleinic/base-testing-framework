# base-testing-framework

This framework provides the following samples:
Reusable API clients (CatalogClient, SearchClient)
Step definitions (CategorySteps, ErrorSteps) for business-level interactions
Test data management via configuration properties
Error handling helpers with validation of response codes and messages
Custom soft assertions integrated with Allure reporting
Support for multiple environments (QA, UAT, PROD)

It is extensible for any REST API project with minimal changes.

## Project Structure
src/main/java/com/base/api/testing/framework/
├── config/            # Spring Boot configuration and test data bindings
├── error/             # Error models and providers
├── model/             # API response/request models
│   ├── catalog/       # Place to create DTO classes for catalog API
│   └── search/        # Place to create DTO classes for search API
├── service/client/    # API clients for REST calls
├── steps/             # Step definitions for business logic
├── testdata/          # Test data enums and utilities
└── utils/             # Helpers and reporting utilities (Allure, DataFormatter, CustomAssertions)

src/main/resources/
├── application.yml         # Common Spring Boot settings
├── application-qa.yml      # QA environment configuration
├── application-uat.yml     # UAT environment configuration
└── application-prod.yml    # PROD environment configuration

src/test/java/com/base/api/testing/framework/
├── catalog/       # Place to create test classes for catalog API
├── search/        # Place to create test classes for search API
└── BaseTest.java  # Base class for all test classes
