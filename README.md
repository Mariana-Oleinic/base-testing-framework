# base-testing-framework

## Project Structure

### Main Java Source
- `src/main/java/com/base/api/testing/framework/`
  - `config/` – Spring Boot configuration and test data bindings
  - `error/` – Error models and providers
  - `model/` – API response/request models
    - `catalog/` – DTOs for Catalog API
    - `search/` – DTOs for Search API
  - `service/client/` – API clients for REST calls
  - `steps/` – Step definitions for business logic
  - `testdata/` – Test data enums and utilities
  - `utils/` – Helpers and reporting utilities (Allure, DataFormatter, CustomAssertions)

### Resources
- `src/main/resources/`
  - `application.yml` – Common Spring Boot settings
  - `application-qa.yml` – QA environment configuration
  - `application-uat.yml` – UAT environment configuration
  - `application-prod.yml` – PROD environment configuration

### Test Source
- `src/test/java/com/base/api/testing/framework/`
  - `catalog/` – Test classes for Catalog API
  - `search/` – Test classes for Search API
  - `BaseTest.java` – Base class for all test classes
