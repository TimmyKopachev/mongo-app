package org.mongo.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class Employee {

    @Id
    private String uuid = UUID.randomUUID().toString();
    private Integer age;
    private String name;
    private String email;
    private String position;
}
