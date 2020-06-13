package com.company.devices;

import com.company.creatures.Human;

import java.io.File;


public abstract class Car extends Device {
    private static final Double DEFAULT_VALUE_CARVALUE = 3000.0;

    String color;
    File pic;
    public Double value = DEFAULT_VALUE_CARVALUE;
    public Human[] sellerList;

    public Car(String model, String producer, Integer yearOfTheProduction, Double value) {
        this.model = model;
        this.producer = producer;
        this.yearOfTheProduction = yearOfTheProduction;
        this.value = value;
    }

    public Double getValue() {
        return this.value;
    }

    public Integer getYear() {
        return this.yearOfTheProduction;
    }

    public String toString() {
        return this.producer + " " + this.model + " " + this.yearOfTheProduction;
    }

    @Override
    public void turnOn() {
        System.out.println("Przekręcenie kluczyka powoduje odpalenie silnika...");
    }


    public void sellCar(Human seller, int selectSellerPlace, Human buyer, Double price) {
        if (seller.getCar(selectSellerPlace) == null) {
            System.out.println("[error] Nie posiada samochodu, który mógłby sprzedać.");
            return;
        } else if (buyer.cash < price) {
            System.out.println("[error] Masz za mało pieniędzy.");
            return;
        } else if (buyer.garage != null) {
            System.out.println("Nie posiadasz miejsca w garażu");

        }

        buyer.cash -= price;
        seller.cash += price;

        buyer.setCar(seller.getCar(selectSellerPlace), buyer.freeGaragePlace());
        seller.setCar(null, selectSellerPlace);
        //sellerList(seller.toString());
        System.out.println("[succes] Udany zakup samochodu: " + buyer.freeGaragePlace());
    }
}