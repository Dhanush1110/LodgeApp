package com.lodgemanagment.app.service;

import com.lodgemanagment.app.entity.Room;
import com.lodgemanagment.app.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAvailableRooms() {
        return roomRepository.findByOccupiedIsNullAndAvailabilityIsTrue();
    }

    public Room bookRoom(String roomNumber, String customerEmail) {
        Room room = roomRepository.findByRoomNumber(roomNumber);
        if (room == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found");
        }
        if (room.getOccupied() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Room is already booked");
        }
        room.setOccupied(customerEmail);
        room.setBookingDate(LocalDateTime.now());
        roomRepository.save(room);
        return room;
    }
}
