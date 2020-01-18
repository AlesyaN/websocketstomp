package ru.itis.websocketstomp.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import ru.itis.websocketstomp.dto.MessageDTO;
import ru.itis.websocketstomp.models.Message;
import ru.itis.websocketstomp.services.MessageService;

/**
 * 20.03.2018
 * MessageController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Controller
public class MessageController {

    @Autowired
    SimpMessagingTemplate template;

    @Autowired
    MessageService messageService;

    @Value("${secret-key}")
    String secretKey;

    @MessageMapping("/chat")
    @CrossOrigin
    public void sendMessage(@Payload MessageDTO messageDTO) {
        String name = null;
        Long id = null;
        try {
            Claims body = Jwts.parser().setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes())).parseClaimsJws(messageDTO.getToken()).getBody();
            name = (String) body.get("name");
            id = ((Integer) body.get("id")).longValue();
        } catch (JwtException e) {
            System.out.println("Invalid token!");
            e.printStackTrace();
            throw new IllegalArgumentException(e);
        }
        messageDTO.setSenderId(id);
        Message message = messageService.saveMessage(messageDTO);
        messageDTO.setSender(message.getSender().getName());
        messageDTO.setDate(message.getDate());
        try {
            template.convertAndSend("/topic/" + messageDTO.getRoomId(), (new ObjectMapper()).writeValueAsString(messageDTO));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
