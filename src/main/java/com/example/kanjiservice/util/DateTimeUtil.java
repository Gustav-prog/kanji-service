package com.example.kanjiservice.util;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTimeUtil {

    private DateTimeUtil() {
    }

    public static LocalDateTime now() {
        return LocalDateTime.now(ZoneId.of("UTC"));
    }

}