package ru.itis.websocketstomp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.websocketstomp.dto.MessageDTO;
import ru.itis.websocketstomp.models.Message;
import ru.itis.websocketstomp.repositories.MessageRepository;
import ru.itis.websocketstomp.repositories.RoomRepository;
import ru.itis.websocketstomp.repositories.UserRepository;

import java.util.Date;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    UserRepository userRepository;

    public Message saveMessage(MessageDTO messageDTO) {
        Message message = Message.builder()
                .date(new Date())
                .room(roomRepository.getOne(messageDTO.getRoomId()))
                .sender(userRepository.getOne(messageDTO.getSenderId()))
                .text(messageDTO.getText())
                .build();
        return messageRepository.save(message);
    }

    public List<Message> getMessagesByRoomId(Long roomId) {
        return messageRepository.findAllByRoom_IdOrderByDateDesc(roomId);
    }
}
