package com.company.devices;


import com.company.creatures.Human;

public class DieselCar extends Car {
    public DieselCar(String model, String producer, Integer yearOfTheProduction, Double value) {
        super(model, producer, yearOfTheProduction, value);
    }

    @Override
    public void turnOn() {
        super.turnOn();
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {

    }

}
