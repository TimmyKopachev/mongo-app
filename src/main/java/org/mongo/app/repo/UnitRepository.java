package org.mongo.app.repo;

import org.mongo.app.model.Unit;
import org.springframework.data.repository.CrudRepository;


public interface UnitRepository extends CrudRepository<Unit, String> {

}
