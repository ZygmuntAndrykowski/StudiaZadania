package com.company.creatures;

import com.company.salleable;

import java.io.File;

public abstract class Animal implements salleable, Feedable {
    final String species;
    private final Double foodWeight = 0.0;
    File pic = null;
    public String name;
    static final Double DEFAULT_DOG_WEIGHT = 10.0;
    static final Double DEFAULT_DRAGON_WEIGHT = 1000.0;
    static final Double DEFAULT_OTHER_WEIGHT = 65.0;
    Double weight;

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

    public void feed() {
        if (this.weight <= 0.0) System.out.println("Twoje zwierze jest martwe, nie musisz go już karmić. ");
        else if (this.weight <= 100.0) {
            this.weight += 1.0;
            System.out.println("Dziękuje, Byłem tak bardzo głodny, moja waga teraz: " + this.weight);
        }
    }

    void takeForAWalk() {

        if (this.weight <= 0.0)
            System.out.println("Twój zwierze jest martw. Nie musisz z nim wychodzić na spacer więcej.");
        else if (this.weight >= 100.0) {
            System.out.println("Twoje zwierze jest zbyt grubę. Przez wagę nie może się ruszyć.");
        } else if (this.weight <= 1.0) {
            System.out.println("Jestem bardzo głodny, nakarm mnie pierw.");
        } else {
            this.weight -= 0.5;
            System.out.println("Dziękuje, Cieszę się że mogliśmy wyjsć razem na spacer. Moja waga teraz wynosi: " + this.weight);
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
