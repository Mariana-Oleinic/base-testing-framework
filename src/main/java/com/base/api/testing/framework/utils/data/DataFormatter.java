package com.base.api.testing.framework.utils.data;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
public class DataFormatter {

    public String generateFutureTimestamp(int numberOfDaysAhead) {
        LocalDateTime futureDateTime = LocalDateTime.now().plusDays(numberOfDaysAhead);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh.mm.ss.SSSSSS a", Locale.ENGLISH);
        return futureDateTime.format(formatter).toUpperCase();
    }

    public String generateCurrentTimestamp() {
        LocalDateTime currentDateTime = LocalDateTime.now(ZoneId.of("UTC"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh.mm.ss.SSSSSS a", Locale.ENGLISH);
        return currentDateTime.format(formatter).toUpperCase();
    }
}
