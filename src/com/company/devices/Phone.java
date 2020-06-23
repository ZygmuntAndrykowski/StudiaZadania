package com.company.devices;

import com.company.Application;
import com.company.creatures.Human;

import java.util.HashSet;
import java.util.Set;

public class Phone extends Device {
    Double screenSize;

    //Lista zainstalowanych aplikacji na telefonie
    Set<Application> phoneApps = new HashSet<>();

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

    public boolean searchForAppsName(Application app) {

        return this.phoneApps.contains(app.appName);
    }

    public boolean searchForAppsObject(Application appName) {

        return this.phoneApps.contains(appName);
    }

    public Double valuePhoneApps() {
        Double sumAppsOnPhone = 0.0;
        for (Application apps : phoneApps) {
            if (apps != null) sumAppsOnPhone += apps.appValue;
        }
        return sumAppsOnPhone;
    }


    //Instalacja aplikacji
    public void installAnnApp(Human owner, Application appName) {
        if (phoneApps.contains(appName)) {
            System.out.println("Aplikacja już jest zainstalowana");
            return;
        } else if (owner.getCash() < appName.getAppValue()) {
            System.out.println("Aplikacja jest za droga");
            return;
        } else {
            System.out.println("Instalacja aplikacji: " + appName.toString() + "Proszę czekać.");
            this.phoneApps.add(appName);
            owner.cash = owner.cash - appName.appValue;
            System.out.println("Instalacja ukończona.");
        }

    }





   /* public void installAnnApp(String appName) {
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
    } */
}
