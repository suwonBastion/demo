package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String convertDate(String date) throws UnsupportedEncodingException {
        return  date
                .replace(":", "%3A")
                .replace("+", "%2B");
    }

    public static String nowDate() {
        return LocalDateTime
                .now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
