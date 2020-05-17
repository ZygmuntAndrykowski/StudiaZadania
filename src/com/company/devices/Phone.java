package com.company.devices;

import com.company.Human;

public class Phone extends Device {

    Double screenSize;

    public Phone(String model, String producer, Integer yearOfTheProduction, Double screenSize) {
        this.model = model;
        this.producer = producer;
        this.yearOfTheProduction = yearOfTheProduction;
        this.screenSize = screenSize;
    }

    public String toString() {
        return this.producer + " " + this.model + " " + this.screenSize;
    }

    @Override
    public void turnOn() {
        System.out.println("Uruchamianie telefonu...");
    }

    public void sell(Human seller, Human buyer, Double price) {
        if (seller.getPhone() == null) {
            System.out.println("[error] Nie posiada samochodu, który mógłby sprzedać.");
            return;
        } else if (buyer.cash < price) {
            System.out.println("[error] Masz za mało pieniędzy.");
            return;
        }

        buyer.cash -= price;
        seller.cash += price;

        buyer.setPhone(seller.getPhone());
        seller.setPhone(null);

        System.out.println("[succes] Udany zakup telefonu: " + buyer.getPhone());
    }
}
