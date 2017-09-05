package io.github.neferupito.hederahotel.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter {

    private final static String DATE_COMPLETE = "dd-MM-yyyy HH:mm";
    private final static String DATE_SHORT = "dd-MM-yyyy";

    public static Date parseComplete(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_COMPLETE, Locale.getDefault());
        return sdf.parse(date);
    }

    public static Date parseShort(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_SHORT, Locale.getDefault());
        return sdf.parse(date);
    }

}
