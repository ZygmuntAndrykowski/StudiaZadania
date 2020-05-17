package com.company.devices;

import com.company.creatures.Human;

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

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (seller.getCar() == null) {
            System.out.println("[error] Nie posiada samochodu, który mógłby sprzedać.");
            return;
        } else if (buyer.cash < price) {
            System.out.println("[error] Masz za mało pieniędzy.");
            return;
        }

        buyer.cash -= price;
        seller.cash += price;

        buyer.setCar(seller.getCar());
        seller.setCar(null);

        System.out.println("[succes] Udany zakup samochodu: " + buyer.getCar());
    }
}