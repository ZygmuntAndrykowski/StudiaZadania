package com.company.devices;

public abstract class Device {
    String model;
    String producer;
    Integer yearOfTheProduction;

    public String toString() {
        return this.producer + " " + this.model + " " + this.yearOfTheProduction;
    }

    public abstract void turnOn();
}
