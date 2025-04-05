package ru.akhmat.spring_security_example.impl;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.akhmat.spring_security_example.models.Application;
import ru.akhmat.spring_security_example.repository.ApplicationRepository;

import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Repository
public class ApplicationRepositoryImpl implements ApplicationRepository {
    private List<Application> applications;

    @PostConstruct
    public void init() {
        Faker faker = new Faker();
        applications = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> Application.builder()
                        .id(i)
                        .name(faker.app().name())
                        .author(faker.app().author())
                        .version(faker.app().version())
                        .build())
                .toList();
    }

    @Override
    public List<Application> findAll() {
        return applications;
    }

    @Override
    public Optional<Application> findById(int id) {
        return applications.stream()
                .filter(app -> app.getId() == id)
                .findFirst();
    }
}