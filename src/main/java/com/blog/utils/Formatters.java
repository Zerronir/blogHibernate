package com.blog.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Formatters {
    public static String formattedDate(LocalDate date) {
        String r = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        // Format the date
        r = date.format(formatter);
        return r;
    }
}
