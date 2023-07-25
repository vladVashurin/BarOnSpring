package com.vld;


import com.vld.model.Alcohol;
import com.vld.model.AlcoholType;
import com.vld.model.Bar;
import com.vld.service.BarService;
import com.vld.service.impl.AlcoholServiceImpl;
import com.vld.service.impl.AlcoholTypeServiceImpl;
import com.vld.service.impl.BarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication(scanBasePackages = {
        "com.vld"})
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Autowired
    public Application(AlcoholServiceImpl alcoholService, AlcoholTypeServiceImpl alcoholTypeService, BarServiceImpl barService) {
        this.service = alcoholService;
        this.alcoholTypeService = alcoholTypeService;
        this.barService = barService;
    }

    private final BarService barService;
    private final AlcoholServiceImpl service;
    private final AlcoholTypeServiceImpl alcoholTypeService;

    @Override
    public void run(String... args) throws Exception {
        AlcoholType alcoholType = new AlcoholType(40d);
        Long id = alcoholTypeService.create(alcoholType);
        AlcoholType alcoholType1 = alcoholTypeService.get(id);
        alcoholTypeService.create(alcoholType1);
        Alcohol alcohol = new Alcohol("Джин", alcoholType);
        service.create(alcohol);
        Bar bar = new Bar("Пабчик", "Улица колотушкина, дом 7", List.of(alcohol));
        barService.create(bar);
    }
}