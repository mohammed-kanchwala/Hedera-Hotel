package io.github.neferupito.hederahotel.service.impl;

import io.github.neferupito.hederahotel.model.booking.Booking;
import io.github.neferupito.hederahotel.model.room.Category;
import io.github.neferupito.hederahotel.model.room.Room;
import io.github.neferupito.hederahotel.repository.booking.BookingRepository;
import io.github.neferupito.hederahotel.repository.room.RoomRepository;
import io.github.neferupito.hederahotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Optional<Room> findFreeRoom(Date startDate, Date endDate, Category category) {
        List<Room> allRooms = roomRepository.findByCategory(category);
        return allRooms
                .parallelStream()
                .filter(room -> isTheRoomFreeDuringThisPeriod(room, startDate, endDate))
                .findFirst();
    }

    private boolean isTheRoomFreeDuringThisPeriod(Room room, Date startDate, Date endDate) {
        Calendar s1 = Calendar.getInstance();
        s1.setTime(startDate);
        Calendar e1 = Calendar.getInstance();
        e1.setTime(endDate);
        List<Booking> bookings = bookingRepository.findByRoomAndCheckout(room, false, false, false);
        boolean foundABlockingBooking = bookings.parallelStream()
                .anyMatch(booking -> {
                    Calendar s2 = Calendar.getInstance();
                    s2.setTime(booking.getArrivalDate());
                    Calendar e2 = Calendar.getInstance();
                    e2.setTime(booking.getDepartureDate());
                    if (s2.before(s1)) {
                        if (!e2.before(s1)) {
                            return true;
                        }
                    } else {
                        if (s2.before(e1)) {
                            return true;
                        }
                    }
                    return false;
                });

        return !foundABlockingBooking;
    }

}
