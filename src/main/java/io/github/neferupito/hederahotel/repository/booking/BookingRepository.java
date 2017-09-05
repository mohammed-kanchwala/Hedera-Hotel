package io.github.neferupito.hederahotel.repository.booking;

import io.github.neferupito.hederahotel.model.booking.Booking;
import io.github.neferupito.hederahotel.model.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {
    List<Booking> findByRoomAndCheckout(Room room, boolean isCheckedIn, boolean isCheckedOut, boolean isCanceled);
}
