package ru.akhmat.spring_security_example.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Application {
    private int id;
    private String name;
    private String author;
    private String version;
}
