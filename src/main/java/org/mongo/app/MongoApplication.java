package org.mongo.app;

import lombok.extern.slf4j.Slf4j;
import org.mongo.app.repo.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@SpringBootApplication
public class MongoApplication {

    @Autowired
    private UnitService unitService;

    public static void main(String[] args) {
        new SpringApplicationBuilder().sources(MongoApplication.class).bannerMode(Banner.Mode.OFF).run(args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void executeMockCode() {
        log.info("====clean up Units from Mongo====");
        log.info("removed {} records", unitService.cleanup());

        log.info("====add dummy units to Mongo====");
        unitService.createDummyUnit();

        System.out.println("===================");
        System.out.println(unitService.findUnitsByEmployeeName("Dzmitry Kapachou"));
    }
}
