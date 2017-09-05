package io.github.neferupito.hederahotel.repository.room;

import io.github.neferupito.hederahotel.model.room.Category;
import io.github.neferupito.hederahotel.model.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    List<Room> findByCategory(Category category);

}
