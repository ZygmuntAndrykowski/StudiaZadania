package com.company.creatures;

public class FarmAnimal extends Animal implements Edbile {
    public FarmAnimal(String species) {
        super(species);
    }

    @Override
    public void beEaten() {
        System.out.println(this.species + " został zjedzony. ");
        this.weight = 0.0;
        return;
    }


    @Override
    public void feed() {
        if (this.weight <= 0.0) System.out.println("Twoje zwierze jest martwe, nie musisz go już karmić. ");
        else if (this.weight <= 100.0) {
            this.weight += 1.0;
            System.out.println("Dziękuje, Byłem tak bardzo głodny, moja waga teraz: " + this.weight);
        }
    }

    @Override
    public void feed(Double foodWeight) {
        if (this.weight <= 0.0) System.out.println("Twoje zwierze jest martwe, nie musisz go już karmić. ");
        else if (this.weight <= 100.0) {
            this.weight += foodWeight;
            System.out.println("Dziękuje, Byłem tak bardzo głodny, moja waga teraz: " + this.weight);
        }
    }
}
