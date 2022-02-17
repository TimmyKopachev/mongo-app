package org.mongo.app.repo;

import lombok.AllArgsConstructor;
import org.mongo.app.model.Employee;
import org.mongo.app.model.Unit;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class UnitService {

    private final MongoTemplate mongoTemplate;
    private final UnitRepository unitRepository;

    public List<Unit> getUnitsByEmployee() {
        Query query = new Query();
        query.addCriteria(Criteria.where("employees").exists(false));
        return mongoTemplate.find(query, Unit.class);
    }

    public void createDummyUnit() {
        Unit unit1 = new Unit();
        unit1.setName("development");

        Employee employee1 = new Employee();
        employee1.setAge(26);
        employee1.setFullName("Dzmitry Kapachou");
        employee1.setPosition("Software engineer");
        employee1.setEmail("dzmitry.kapachou@company.com");

        unit1.setEmployees(Stream.of(employee1).collect(Collectors.toList()));

        Unit unit2 = new Unit();
        unit2.setName("analytics department");
        unit2.setEmployees(Stream.of(employee1).collect(Collectors.toList()));

        Unit unit3 = new Unit();
        unit3.setName("accounting");

        Stream.of(unit1, unit2, unit3).forEach(unitRepository::save);

    }

}
