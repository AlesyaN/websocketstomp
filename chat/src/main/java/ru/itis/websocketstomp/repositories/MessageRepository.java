package ru.itis.websocketstomp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.websocketstomp.models.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByRoom_IdOrderByDateDesc(Long roomId);
}
