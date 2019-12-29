package ru.itis.websocketstomp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.websocketstomp.services.RoomsService;

@RestController
public class RoomController {

    @Autowired
    public RoomsService roomsService;

    @GetMapping("/room/all")
    public ResponseEntity getRoomsList() {
        return ResponseEntity.ok(roomsService.getRoomList());
    }

    @PostMapping("/room/add")
    public ResponseEntity addRoom(String name) {
        return ResponseEntity.ok(roomsService.addRoom(name));
    }
}
