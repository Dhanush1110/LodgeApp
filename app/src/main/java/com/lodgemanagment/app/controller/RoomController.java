package com.lodgemanagment.app.controller;

import com.lodgemanagment.app.entity.Room;
import com.lodgemanagment.app.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/available")
    public ResponseEntity<List<Room>> getAvailableRooms() {
        List<Room> availableRooms = roomService.getAvailableRooms();
        return ResponseEntity.ok(availableRooms);
    }

    @PostMapping("/book")
    public ResponseEntity<String> bookRoom(@RequestParam String roomNumber, @RequestParam String customerEmail) {
        try {
            Room bookedRoom = roomService.bookRoom(roomNumber, customerEmail);
            return ResponseEntity.ok("Room booked successfully: " + bookedRoom.getRoomNumber());
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        }
    }

}
