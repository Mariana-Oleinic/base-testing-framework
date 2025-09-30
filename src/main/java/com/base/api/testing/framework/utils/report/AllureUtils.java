package com.base.api.testing.framework.utils.report;

import io.qameta.allure.Attachment;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class AllureUtils {

    @Attachment(value = "CSV Attachment", type = "text/csv")
    public byte[] attachCSVFile(File file) {
        try {
            return Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
