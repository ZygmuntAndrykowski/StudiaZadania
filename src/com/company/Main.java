package com.company;

import com.company.devices.Car;
import com.company.devices.Phone;

public class Main {

    public static void main(String[] args) {

        Human me = new Human("Homo Sapiens");
        me.firstName = "Zygmunt";
        me.lastName = "Andrykowski";

        Human meClone = new Human("Homo Sapiens");
        meClone.firstName = "Zygmunt_klon";
        meClone.lastName = "Andrykowski_klon";

        Human human = new Human("Homo Sapiens");
        human.firstName = "Andrzej";
        human.lastName = "Zwierzynski";

        Animal dog = new Animal("Dog");
        dog.name = "Doggie";
        me.pet = meClone;


        Car mazda = new Car("6", "Mazda", 2005);
        Car renault = new Car("Scenic", "Renault", 1998);

        Phone Samsung = new Phone("Avilla", "Samsung", 2003, 4.0);

        me.setSalary(2500.0);
        me.getSalary();
        me.cash = 3000.0;
        human.cash = 5000.0;

        System.out.println(me.getCash());

        meClone.setCar(mazda);
        meClone.getCar();
        me.setPhone(Samsung);

        mazda.sell(meClone, me, 1000.0);
        System.out.println(me.toString() + " posiada samochód: " + me.getCar());
        Samsung.sell(me, meClone, 500.0);
        System.out.println(meClone.toString() + " posiada telefon: " + meClone.phone.toString());

        meClone.sell(me, human, 1500.0);
        System.out.println(human.toString() + " posiada zwierze: " + human.getAnimal());

    }
}
