package com.company;

import java.io.File;

public class Car {

    final String model;
    final String producer;
    final Integer yearOfTheProduction;
    String color;
    File pic;


    public Car(String model, String producer, Integer yearOfTheProduction) {
        this.model = model;
        this.producer = producer;
        this.yearOfTheProduction = yearOfTheProduction;
    }


}