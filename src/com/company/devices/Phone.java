package com.company.devices;

public class Phone {
    String producer;
    String model;
    Double screenSize;

    public String toString() {
        return this.producer + " " + this.model + " " + this.screenSize;
    }
}
