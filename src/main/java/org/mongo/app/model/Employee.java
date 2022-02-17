package org.mongo.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document
public class Employee {

    @Id
    private String uuid = UUID.randomUUID().toString();
    private Integer age;
    private String fullName;
    private String email;
    private String position;
}
