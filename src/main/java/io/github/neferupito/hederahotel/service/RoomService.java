package io.github.neferupito.hederahotel.service;

import io.github.neferupito.hederahotel.model.room.Category;
import io.github.neferupito.hederahotel.model.room.Room;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RoomService {

    Optional<Room> findFreeRoom(Date startDate, Date endDate, Category category);

}
