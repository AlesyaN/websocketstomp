package ru.itis.websocketstomp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.websocketstomp.dto.RoomDTO;
import ru.itis.websocketstomp.services.MessageService;

@RestController
public class ChatRestController {

    @Autowired
    MessageService messageService;

    @GetMapping("/messages")
    @CrossOrigin
    public ResponseEntity getAllMessages(@RequestParam("roomId") Long id) {
        return ResponseEntity.ok(messageService.getMessagesByRoomId(id));
    }

}
