package io.github.neferupito.hederahotel.service.impl;

import io.github.neferupito.hederahotel.model.booking.Booking;
import io.github.neferupito.hederahotel.model.booking.TemporaryBooking;
import io.github.neferupito.hederahotel.model.reporting.History;
import io.github.neferupito.hederahotel.model.reporting.HistoryMessages;
import io.github.neferupito.hederahotel.model.room.Room;
import io.github.neferupito.hederahotel.model.user.User;
import io.github.neferupito.hederahotel.repository.booking.BookingRepository;
import io.github.neferupito.hederahotel.service.BookingService;
import io.github.neferupito.hederahotel.service.RoomService;
import io.github.neferupito.hederahotel.util.BookingReferenceGenerator;
import io.github.neferupito.hederahotel.util.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RoomService roomService;
    @Value("${date.format.complete}")
    private String dateFormatString;

    @Override
    public TemporaryBooking buildTemporaryBooking(TemporaryBooking temporaryBooking) throws ParseException {
        BookingReferenceGenerator generator = new BookingReferenceGenerator();
        temporaryBooking.setArrivalDate(temporaryBooking.getArrivalDate() + " 15:00");
        temporaryBooking.setDepartureDate(temporaryBooking.getDepartureDate() + " 11:00");
        temporaryBooking.setBookingReference(generator.generateBookingReference(DateFormatter.parseComplete(temporaryBooking.getArrivalDate()), DateFormatter.parseComplete(temporaryBooking.getDepartureDate())));
        return temporaryBooking;
    }

    @Override
    public Booking confirmBooking(TemporaryBooking temporaryBooking, Room room, User user) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormatString, Locale.getDefault());

        Booking booking = Booking.builder()
                .bookingReference(temporaryBooking.getBookingReference())
                .arrivalDate(sdf.parse(temporaryBooking.getArrivalDate()))
                .departureDate(sdf.parse(temporaryBooking.getDepartureDate()))
                .adults(temporaryBooking.getAdults())
                .children(temporaryBooking.getChildren())
                .customer(temporaryBooking.getCustomer())
                .history(History.createHistoryWithFirstLine(HistoryMessages.BOOKING_CREATED, user))
                .build();

        return bookingRepository.save(booking);
    }

}
