package com.company.creatures;

public class Pet extends Animal {
    public Pet(String species) {
        super(species);
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
