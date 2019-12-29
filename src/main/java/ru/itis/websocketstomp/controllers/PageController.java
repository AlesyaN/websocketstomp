package ru.itis.websocketstomp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/{roomId}")
    public String getChatPage(@PathVariable String roomId) {
        return "chat";
    }

}
