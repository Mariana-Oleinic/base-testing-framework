package com.base.api.testing.framework.testdata;

import com.base.api.testing.framework.config.TestDataConfigurationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataUtils {

    private final TestDataConfigurationProperties testData;

    public TestDataConfigurationProperties.Product getProductTestDataByType(ItemType itemType) {
        return switch (itemType) {
            case WARRANTY -> testData.getProducts().getWarranty();
            case NON_VARIANT -> testData.getProducts().getNonVariant();
            case MULTI_VARIANT -> testData.getProducts().getMultiVariant();
            case NON_EXISTING -> testData.getProducts().getNonExisting();
            default -> throw new IllegalStateException("Test data is missing for product type: " + itemType);
        };
    }

    public TestDataConfigurationProperties.Sku getSkuTestDataByType(ItemType itemType) {
        return switch (itemType) {
            case GIFT_CARD -> testData.getSkus().getGiftCard();
            case MULTI_VARIANT -> testData.getSkus().getMultiVariant();
            default -> throw new IllegalStateException("Test data is missing for sku type: " + itemType);
        };
    }
}
