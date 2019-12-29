package ru.itis.websocketstomp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.websocketstomp.services.MessageService;

@RestController
public class ChatRestController {

    @Autowired
    MessageService messageService;

    @GetMapping("/messages")
    public ResponseEntity getAllMessages(@RequestParam("roomId") Long roomId) {
        return ResponseEntity.ok(messageService.getMessagesByRoomId(roomId));
    }

}
