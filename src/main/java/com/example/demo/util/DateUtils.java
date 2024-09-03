package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class DateUtils {

    public static String convertDate(String date) throws UnsupportedEncodingException {
        return  date
                .replace(":", "%3A")
                .replace("+", "%2B");
    }
}
