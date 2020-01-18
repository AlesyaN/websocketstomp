package ru.itis.websocketstomp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.websocketstomp.dto.UserDTO;
import ru.itis.websocketstomp.models.User;
import ru.itis.websocketstomp.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User registerUser(UserDTO userDTO) {
        return userRepository.save(User.builder().name(userDTO.getName()).build());
    }
}
