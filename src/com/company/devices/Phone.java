package com.company.devices;

public class Phone extends Device {

    Double screenSize;

    public String toString() {
        return this.producer + " " + this.model + " " + this.screenSize;
    }

    @Override
    public void turnOn() {
        System.out.println("Uruchamianie telefonu...");
    }
}
