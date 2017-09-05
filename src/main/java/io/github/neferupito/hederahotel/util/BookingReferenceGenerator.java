package io.github.neferupito.hederahotel.util;

import org.apache.commons.text.RandomStringGenerator;

import java.util.Calendar;
import java.util.Date;

public class BookingReferenceGenerator {

    public String generateBookingReference(Date startDate, Date endDate) {
        StringBuilder sb = new StringBuilder();

        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('a', 'z')
//                .filteredBy(LETTERS, DIGITS)
                .build();

        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);
        int startDay = startCalendar.get(Calendar.DAY_OF_MONTH);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        int endDay = endCalendar.get(Calendar.DAY_OF_MONTH);

        return sb
                .append(startDay < 10 ? "0" + startDay : startDay)
                .append(generator.generate(3))
                .append(endDay < 10 ? "0" + endDay : endDay)
                .append(generator.generate(3))
                .toString()
                .toUpperCase();

    }


}
