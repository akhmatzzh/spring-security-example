package ru.akhmat.spring_security_example.repository;

import org.springframework.stereotype.Repository;
import ru.akhmat.spring_security_example.models.Application;

import java.util.List;
import java.util.Optional;


public interface ApplicationRepository {
    List<Application> findAll();
    Optional<Application> findById(int id);
}
