package org.mongo.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@Document
public class Unit {

    @Id
    private String uuid = UUID.randomUUID().toString();
    private String name;
    private List<Employee> employees;

}
