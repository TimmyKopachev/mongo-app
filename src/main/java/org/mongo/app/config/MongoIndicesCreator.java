package org.mongo.app.config;

import lombok.AllArgsConstructor;
import org.mongo.app.model.Employee;
import org.mongo.app.model.Unit;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MongoIndicesCreator implements ApplicationRunner {

    private final MongoOperations mongoOperations;

    @Override
    public void run(ApplicationArguments args) {
        this.createUnitIndices();
        this.createEmployeeIndices();
    }

    private void createEmployeeIndices() {
        mongoOperations.indexOps(Employee.class)
                .ensureIndex(new Index().on("fullName", Sort.Direction.DESC));

        mongoOperations.indexOps(Employee.class)
                .ensureIndex(new Index().on("position", Sort.Direction.DESC));
    }

    private void createUnitIndices() {
        mongoOperations.indexOps(Unit.class)
                .ensureIndex(new Index().on("name", Sort.Direction.DESC));
    }

}
