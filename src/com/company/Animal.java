package com.company;

import java.io.File;

public class Animal implements salleable {
    final String species;
    String name;
    File pic = null;
    private Double weight;
    static final Double DEFAULT_DOG_WEIGHT = 10.0;
    static final Double DEFAULT_DRAGON_WEIGHT = 1000.0;
    static final Double DEFAULT_OTHER_WEIGHT = 65.0;

    public String toString() {
        return this.species + " " + this.name + " " + this.weight;
    }

    public Animal(String species) {
        this.species = species;
        if (species.equals("Dog")) weight = DEFAULT_DOG_WEIGHT;
        else if (species.equals("Dragon")) {
            weight = DEFAULT_DRAGON_WEIGHT;
        } else weight = DEFAULT_OTHER_WEIGHT;
    }

    void feed() {
        this.weight++;
        System.out.println("Thx, I be so hungry, my weight is now " + this.weight);
        if (this.weight <= 0.0) System.out.println("Your Pet is dead. You don't need feed him anymore");
        else if (this.weight <= 100.0) {
            this.weight += 1.0;
            System.out.println("Thx, I be so hungry, my weight is now " + this.weight);
        }
    }

    void takeForAWalk() {

        if (this.weight <= 0.0) System.out.println("Your Pet is dead. You don't need walk with him anymore");
        else if (this.weight >= 100.0) {
            System.out.println("Your Pet is too big. He Can't walk becouse his weight ");
        } else if (this.weight <= 1.0) {
            System.out.println("I'm so hungry, feed me first ");
        } else {
            this.weight -= 0.5;
            System.out.println("Thx, I be so happy to walk with you, my weight is now " + this.weight);
        }
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (seller.getAnimal() == null) {
            System.out.println("[error] Nie posiada samochodu, który mógłby sprzedać.");
            return;
        } else if (buyer.cash < price) {
            System.out.println("[error] Masz za mało pieniędzy.");
            return;
        } else if (seller.pet.species == "Homo Sapiens") {
            System.out.println("Ty chory... człowieku, nie wolno sprzedawać innych ludzi.");
            return;
        }

        buyer.cash -= price;
        seller.cash += price;

        buyer.setAnimal(seller.getAnimal());
        seller.setAnimal(null);

        System.out.println("[succes] Udany zakup zwierzęcia: " + buyer.getAnimal() + " opiekuj się nim.");
    }
}
