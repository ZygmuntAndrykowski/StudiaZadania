package com.company;

import com.company.creatures.Human;
import com.company.creatures.Pet;
import com.company.devices.Car;
import com.company.devices.DieselCar;
import com.company.devices.LPGCar;
import com.company.devices.Phone;

import java.util.Arrays;
import java.util.Comparator;


public class Main {

    public static void main(String[] args) {

        Human me = new Human("Homo Sapiens", 5);
        me.firstName = "Zygmunt";
        me.lastName = "Andrykowski";

        Human meClone = new Human("Homo Sapiens", 3);
        meClone.firstName = "Zygmunt_klon";
        meClone.lastName = "Andrykowski_klon";

        Human human = new Human("Homo Sapiens", 2);
        human.firstName = "Andrzej";
        human.lastName = "Zwierzynski";

        Pet dog = new Pet("Dog");
        dog.name = "Doggie";
        me.pet = dog;

        dog.feed(10.0);

        DieselCar mazda = new DieselCar("6", "Mazda", 2005, 3000.0);
        LPGCar renault = new LPGCar("Scenic", "Renault", 1998, 3000.0);

        Phone Samsung = new Phone("Avilla", "Samsung", 2003, 4.0);

        me.setSalary(5000.0);
        me.getSalary();

        System.out.println(me.getCash());

        me.setCar(mazda, me.freeGaragePlace());
        me.setCar(renault, me.freeGaragePlace());

        //sortowanie samochodów w garażu ze wzgledu na wiek (od najstarszego do najnowszego, + puste miejsca)
        Arrays.sort(me.garage, Comparator.nullsLast(Comparator.comparing(Car::getYear)));
        System.out.println(Arrays.toString(me.getGarage()));
        me.setPhone(Samsung);

        System.out.println("//////////////////////////////////////////////////////////////////////////////////////");
        mazda.sellCar(me, 1, meClone, 100.0);
        System.out.println(Arrays.toString(meClone.getGarage()));
        System.out.println(Arrays.toString(mazda.getSellerList()));
        mazda.sellCar(meClone, 0, me, 100.0);
        System.out.println(Arrays.toString(me.getGarage()));
        System.out.println(Arrays.toString(mazda.getSellerList()));
        //Sprawdź czy...
        System.out.println("[Zapytanie] Czy " + me.toString() + " posiadał samochód " + mazda.toString() + ": " + mazda.searchForSellerList(me));
        System.out.println("[Zapytanie] Czy " + me.toString() + " sprzedał samochód " + mazda.toString() + " " + meClone.toString() + ": " + mazda.checkForSellerList(me, meClone));
        System.out.println("[Zapytanie] Czy " + meClone.toString() + " sprzedał samochód " + mazda.toString() + " " + me.toString() + ": " + mazda.checkForSellerList(meClone, me));
        System.out.println("Samochód " + mazda.toString() + " brał udział w " + mazda.getNumberOfSell() + " transakcjach. ");

        Samsung.sell(me, meClone, 500.0);
        System.out.println(meClone.toString() + " posiada telefon: " + meClone.getPhone());

        Samsung.installAnnApp("Twiter, Facebook, Instagram");

    }
}
