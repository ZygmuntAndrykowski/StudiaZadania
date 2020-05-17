package com.company.devices;

import java.io.File;

public class Car extends Device {
    private static final Double DEFAULT_VALUE_CARVALUE = 3000.0;
    String color;
    File pic;
    private final Double value = DEFAULT_VALUE_CARVALUE;


    public Car(String model, String producer, Integer yearOfTheProduction) {
        this.model = model;
        this.producer = producer;
        this.yearOfTheProduction = yearOfTheProduction;
    }

    public Double getValue() {
        return this.value;
    }

    public String toString() {
        return this.producer + " " + this.model + " " + this.yearOfTheProduction;
    }

    @Override
    public void turnOn() {
        System.out.println("Przekręcenie kluczyka powoduje odpalenie silnika...");
    }
}