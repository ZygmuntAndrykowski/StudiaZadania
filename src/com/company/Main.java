package com.company;

import com.company.devices.Car;

public class Main {

    public static void main(String[] args) {

        Human me = new Human();
        me.firstName = "Zygmunt";
        me.lastName = "Andrykowski";

        Animal dog = new Animal("Dog");
        dog.name = "Doggie";
        me.pet = dog;


        Car mazda = new Car("6", "Mazda", 2005);
        Car renault = new Car("Scenic", "Renault", 1998);



        me.setSalary(2500.0);
        me.getSalary();

        me.setCar(mazda);
        me.getCar();
        mazda.turnOn();

    }
}
