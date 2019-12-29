package ru.itis.websocketstomp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.websocketstomp.models.Room;
import ru.itis.websocketstomp.repositories.RoomRepository;

import java.util.List;

@Service
public class RoomsService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getRoomList() {
        return roomRepository.findAll();
    }

    public Room addRoom(String name) {
        Room room = Room.builder().name(name).build();
        return roomRepository.save(room);
    }
}
