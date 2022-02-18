package org.mongo.app.exception;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MongoExceptionHandler {

    @AfterThrowing(pointcut = "execution(* org.mongo.app.repo.UnitService.*(..))", throwing = "ex")
    public void handleMongoException(Exception ex) {
        log.warn("===Mongo thrown an exception===");
        log.warn("Unit with the name provided is already existent");
    }

}
