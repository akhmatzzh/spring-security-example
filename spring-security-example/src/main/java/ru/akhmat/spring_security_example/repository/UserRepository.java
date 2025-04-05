package ru.akhmat.spring_security_example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.akhmat.spring_security_example.models.MyUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByName(String username);
}
