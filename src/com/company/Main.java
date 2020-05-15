package com.company;

public class Main {

    public static void main(String[] args) {

        Human me = new Human();
        me.firstName = "Zygmunt";
        me.lastName = "Andrykowski";

        Animal dog = new Animal("Dog");
        dog.name = "Doggie";
        me.pet = dog;

        Car car = new Car("6", "Mazda", 2005);


        me.setSalary(2500.0);
        me.getSalary();

        me.setCar(car);
        me.getCar();
    }
}
