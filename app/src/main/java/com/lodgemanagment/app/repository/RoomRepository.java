package com.lodgemanagment.app.repository;

import com.lodgemanagment.app.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByOccupiedIsNullAndAvailabilityIsTrue();

    Room findByRoomNumber(String roomNumber);
}
