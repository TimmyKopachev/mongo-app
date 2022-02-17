package org.mongo.app;

import lombok.AllArgsConstructor;
import org.mongo.app.repo.UnitService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MongoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(MongoApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

    @Component
    @AllArgsConstructor
    class CustomApplicationRunner implements ApplicationRunner {

        final UnitService unitService;

        @Override
        public void run(ApplicationArguments args) {
            unitService.createDummyUnit();

            unitService.getUnitsByEmployee().forEach(System.out::println);
        }
    }

}
