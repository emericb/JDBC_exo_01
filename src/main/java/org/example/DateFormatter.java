package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class DateFormatter {
    public static Date formatDate(String dateStr) {
        try {
            java.util.Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateStr);
            return new Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}