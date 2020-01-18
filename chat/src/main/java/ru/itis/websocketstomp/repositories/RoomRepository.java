package ru.itis.websocketstomp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.websocketstomp.models.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
