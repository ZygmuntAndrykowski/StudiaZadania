package com.company;

public class Main {

    public static void main(String[] args) {

        Human me = new Human();
        me.firstName = "Zygmunt";
        me.lastName = "Andrykowski";

        Animal dog = new Animal("Dog");
        dog.name = "Doggie";
        me.pet = dog;

        System.out.println("Hi, I'm " + dog.name);
        System.out.println("My species is " + dog.species);

        dog.feed();
        me.pet.feed();
        System.out.println(me.pet.species);

        me.pet = new Animal("Dragon");
        me.pet.name = "Mysz";


        System.out.println(me.pet.species);
    }
}
