package ru.itis.websocketstomp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.websocketstomp.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
