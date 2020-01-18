package ru.itis.websocketstomp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.websocketstomp.dto.RoomDTO;
import ru.itis.websocketstomp.services.RoomsService;

@RestController
public class RoomController {

    @Autowired
    public RoomsService roomsService;

    @GetMapping("/room/all")
    @CrossOrigin
    public ResponseEntity getRoomsList() {
        return ResponseEntity.ok(roomsService.getRoomList());
    }

    @PostMapping("/room/add")
    @CrossOrigin
    public ResponseEntity addRoom(@RequestBody RoomDTO roomDTO) {
        return ResponseEntity.ok(roomsService.addRoom(roomDTO));
    }
}
