package io.github.neferupito.hederahotel.service;

import io.github.neferupito.hederahotel.model.booking.Booking;
import io.github.neferupito.hederahotel.model.booking.TemporaryBooking;
import io.github.neferupito.hederahotel.model.room.Room;
import io.github.neferupito.hederahotel.model.user.User;

import java.text.ParseException;

public interface BookingService {

    TemporaryBooking buildTemporaryBooking(TemporaryBooking temporaryBooking) throws ParseException;
    Booking confirmBooking(TemporaryBooking temporaryBooking, Room room, User user) throws ParseException;

}
