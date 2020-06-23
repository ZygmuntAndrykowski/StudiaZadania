package com.company.devices;

import com.company.creatures.Human;

import java.io.File;


public abstract class Car extends Device {
    private static final Double DEFAULT_VALUE_CARVALUE = 3000.0;
    private static final Integer DEFAULT_VALUE_MAX_NUMBER_OF_SELLER = 256;


    String color;
    File pic;
    public Double value;
    private Integer numberOfSell;
    public Human[] sellerList;

    public Car(String model, String producer, Integer yearOfTheProduction, Double value) {
        this.model = model;
        this.producer = producer;
        this.yearOfTheProduction = yearOfTheProduction;
        this.value = DEFAULT_VALUE_CARVALUE;
        this.sellerList = new Human[DEFAULT_VALUE_MAX_NUMBER_OF_SELLER];
        this.numberOfSell = 0;
    }

    public Double getValue() {
        return this.value;
    }

    public Integer getYear() {
        return this.yearOfTheProduction;
    }

    public Integer getNumberOfSell() {
        return this.numberOfSell;
    }

    public String toString() {
        return this.producer + " " + this.model + " " + this.yearOfTheProduction;
    }

    public int freeSellerListPlace() {

        for (int i = 0; i != this.sellerList.length; i++) {
            if (this.sellerList[i] == null) {
                return i;
            }

        }
        return -1;
    }

    public Human[] getSellerList() {
        return this.sellerList;
    }

    public void setSellerList(Human buyer) {

        this.sellerList[freeSellerListPlace()] = buyer;
    }

    // Wyszukiwanie czy dany osobnik posiada/ł samochód
    public String searchForSellerList(Human searchHuman) {

        for (int i = 0; i != this.sellerList.length; i++) {
            if (this.sellerList[i] == searchHuman) {
                return "Tak";
            }

        }
        return "Nie";
    }

    public String checkForSellerList(Human seller, Human buyer) {

        for (int i = 0; i != this.sellerList.length; i++) {
            if (this.sellerList[i] == seller) {
                if (this.sellerList[i + 1] == buyer) {
                    return "Tak";
                } else {
                    return "Nope";
                }
            }

        }
        return "Nie";
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
        } else if (buyer.garage == null) {
            System.out.println("[error] Nie posiadasz miejsca w garażu");

        } else if (seller.toString() == this.sellerList.toString()) {
            System.out.println("[error] Sprzedawca nie jest właścielem tego samochodu");
        }

        buyer.cash -= price;
        seller.cash += price;

        buyer.setCar(seller.getCar(selectSellerPlace), buyer.freeGaragePlace());
        seller.setCar(null, selectSellerPlace);
        // Przypisanie poprzedniego właściela do listy samochodu.
        System.out.println("[succes] Udany zakup samochodu. ");
        setSellerList(buyer);
        this.numberOfSell = +1;
    }
}