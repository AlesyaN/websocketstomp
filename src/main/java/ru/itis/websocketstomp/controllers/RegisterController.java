package ru.itis.websocketstomp.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.websocketstomp.models.User;
import ru.itis.websocketstomp.services.UserService;

@RestController
public class RegisterController {

    @Autowired
    UserService userService;

    @Value("${secret-key}")
    String secretKey;

    @PostMapping("/register")
    public ResponseEntity register(String name) {
        User user = userService.registerUser(name);
        String token = Jwts.builder()
                .claim("id", user.getId())
                .claim("name", user.getName())
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()))
                .compact();
        return ResponseEntity.ok(token);
    }

}
