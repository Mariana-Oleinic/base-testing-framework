package com.base.api.testing.framework.utils.report;

import io.qameta.allure.Allure;
import lombok.Getter;
import org.assertj.core.api.SoftAssertions;

public class CustomAssertions {
    public SoftAssertions softly;
    @Getter
    private int successCount;
    @Getter
    private int failureCount;

    public CustomAssertions() {
        this.softly = new SoftAssertions();
        this.successCount = 0;
        this.failureCount = 0;
    }

    public void assertThat(ThrowingRunnable assertion, String description) {
        assertion.run();
        boolean result = softly.wasSuccess();
        if (result) {
            successCount++;
            Allure.step(description + ": 💚 SUCCESS");
        } else {
            failureCount++;
            Allure.step(description + ": 💔 FAILURE");
        }
    }

    public void assertAll() {
        try {
            softly.assertAll();
        } finally {
            Allure.step("💚 Total Successful Assertions: " + successCount);
            Allure.step("💔 Total Failed Assertions: " + failureCount);
        }
    }

    @FunctionalInterface
    public interface ThrowingRunnable {
        void run() throws AssertionError;
    }
}