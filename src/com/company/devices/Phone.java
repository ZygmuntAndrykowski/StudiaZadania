package com.company.devices;

import com.company.creatures.Human;

public class Phone extends Device {
    static final String DEFAULT_APP_VERSION = "LATEST";
    static final String DEFAULT_APP_ADRESS = "voidapp.com/";
    static final String DEFAULT_PROTOCOL = "https";
    String appName;
    String appVersion;
    String appAddress;

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

    public void installAnnApp(String appName) {
        System.out.println("Instaluje aplikacje " + this.appName);
    }

    public void installAnnApp(String appName, String appVersion) {
        System.out.println("Instaluje aplikacje " + this.appVersion + "Ver: " + this.appVersion);
    }

    public void installAnnApp(String appName, String appVersion, String appAddress) {
        System.out.println("Pobieranie aplikacji z adresu: " + this.appAddress);
        System.out.println("Instaluje aplikacje " + this.appVersion + "Ver: " + this.appVersion);
    }

    public void installAnnApp(String[] appNames) {
    }
}
