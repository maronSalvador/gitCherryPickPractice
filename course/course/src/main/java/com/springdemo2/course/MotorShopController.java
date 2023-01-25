package com.springdemo2.course;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MotorShopController {

    @GetMapping("/api/main-page")
    public String mainPage() {

        return "Welcome to my shop!!!!!";

    }
    @GetMapping("/for-sale-models")
    public List<MotorModel> getMotorModels() {

        List<MotorModel> motorModel = new ArrayList<>();
        motorModel.add(new MotorModel("Kawasaki ZH2",
                "Black-Green",
                2020,
                6785,
                720000));
        motorModel.add(new MotorModel("Honda Cb1000r",
                "Gray-Black",
                2020,
                4787,
                750000));
        motorModel.add(new MotorModel("KTM 1290 Super Duke R",
                "Orange-Black",
                2021,
                1530,
                1150000));
        motorModel.add(new MotorModel("BMW R 1250 GS",
                "White",
                2020,
                10632,
                1430000));
        motorModel.add(new MotorModel("Ducati Hypermotard 950 sp",
                "Black-Green",
                2022,
                850,
                1100000));

        return motorModel;

    }

    // @PathVariable to bind url to method parameters
    @GetMapping("/for-sale-models/{modelName}/{color}/{yearModel}/{mileage}/{price}")
    public MotorModel motorModelPath(@PathVariable("modelName") String modelName,
                                     @PathVariable("color") String color,
                                     @PathVariable("yearModel") int yearModel,
                                     @PathVariable("mileage") int mileage,
                                     @PathVariable("price") int price) {

        return new MotorModel(modelName, color, yearModel, mileage, price);
    }

    // API tp handle query parameters
    // http://localhost:8080/for-sale-models/query?modelName=BMW%20R%201250%20GS&color=White&yearModel=2020&mileage=10632&price=14300000
    // web request parameter or query parameter
    @GetMapping("/for-sale-models/query")
    public MotorModel motorModelQuery(@RequestParam(name = "modelName") String modelName,
                                      @RequestParam(name = "color") String color,
                                      @RequestParam(name = "yearModel") int yearModel,
                                      @RequestParam(name = "mileage") int mileage,
                                      @RequestParam(name = "price") int price) {

        return new MotorModel(modelName, color, yearModel, mileage, price);

    }
}
