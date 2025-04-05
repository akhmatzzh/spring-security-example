package ru.akhmat.spring_security_example.services;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.akhmat.spring_security_example.models.Application;
import ru.akhmat.spring_security_example.models.MyUser;
import ru.akhmat.spring_security_example.repository.ApplicationRepository;
import ru.akhmat.spring_security_example.repository.UserRepository;


import java.util.List;

@Service

public class AppService {
    private final ApplicationRepository applicationRepository;

    private final UserRepository repository;
    private PasswordEncoder passwordEncoder;


    public AppService(ApplicationRepository applicationRepository, UserRepository repository) {
        this.applicationRepository = applicationRepository;
        this.repository = repository;
    }

    public List<Application> allApplications() {
        return applicationRepository.findAll();
    }

    public Application applicationById(int id) {
        return applicationRepository.findById(id)
                .orElse(null);
    }

    public void addUser(MyUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }
}