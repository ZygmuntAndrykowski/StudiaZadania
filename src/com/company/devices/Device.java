package com.company.devices;

import com.company.salleable;

public abstract class Device implements salleable {
    String model;
    String producer;
    Integer yearOfTheProduction;
    public Double price;

    public String toString() {
        return this.producer + " " + this.model + " " + this.yearOfTheProduction;
    }

    public abstract void turnOn();

    public Double getPrice() {
        return price;
    }
}
