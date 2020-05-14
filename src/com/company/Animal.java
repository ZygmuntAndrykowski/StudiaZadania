package com.company;

import java.io.File;

public class Animal {
    final String species;
    String name;
    File pic = null;
    private Double weight;
    static final Double DEFAULT_DOG_WEIGHT = 10.0;
    static final Double DEFAULT_DRAGON_WEIGHT = 1000.0;
    static final Double DEFAULT_OTHER_WEIGHT = 1.0;

    public Animal(String species) {
        this.species = species;
        if (species.equals("Dog")) weight = DEFAULT_DOG_WEIGHT;
        else if (species.equals("Dragon")) {
            weight = DEFAULT_DRAGON_WEIGHT;
        } else weight = DEFAULT_OTHER_WEIGHT;


    }
    void feed() {
        weight++;
        System.out.println("Thx, I be so hungry, my weight is now " + weight);
        if (weight <= 0.0) System.out.println("Your Pet is dead. You don't need feed him anymore");
        else if (weight <= 100.0) {
            weight += 1.0;
            System.out.println("Thx, I be so hungry, my weight is now " + weight);
        }
    }

    void takeForAWalk() {

        if (weight <= 0.0) System.out.println("Your Pet is dead. You don't need walk with him anymore");
        else if (weight >= 100.0) {
            System.out.println("Your Pet is too big. He Can't walk becouse his weight ");
        } else if (weight <= 1.0) {
            System.out.println("I'm so hungry, feed me first ");
        } else {
            weight -= 0.5;
            System.out.println("Thx, I be so happy to walk with you, my weight is now " + weight);
        }
    }
}
