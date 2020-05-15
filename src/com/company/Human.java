package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Human {
    String firstName;
    String lastName;

    private Double salary = DEFAULT_SALARY_VALUE;
    private static final Double DEFAULT_SALARY_VALUE = 1700.0;

    Animal pet;

    Phone phone;
    private Car car;

    public Double getSalary()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Data: " + dateFormat.format(date) + ", wartość wypłaty: " + this.salary);
        return this.salary;
    }

    public boolean setSalary(Double value)
    {
        if(value < 0)
        {
            System.out.println("Error: Nie jest możliwe dodanie warości mniejszej niż 0.");
            return false;
        }

        System.out.println("Nowe dane zostały wysłane do działu księgowego.");
        System.out.println("Oczekiwanie na odpowiedź");
        System.out.println("Informacja zwrotna: 1. Aneks do umowy do odebrania u Pani Hani z HR");
        System.out.println("2. ZUS i US już wiedzą o zmianie wypłaty i nie ma sensu ukrywać dochodu.");

        this.salary = value;

        return true;
    }

    public Car getCar() {
        return this.car;
    }

    public boolean setCar(Car car) {
        if (this.salary > car.getValue()) {
            this.car = car;
            System.out.println("Kupiłeś samochód za gotówkę: " + car.producer + " " + car.model);
            System.out.println("Przypisano do właściela: " + this.firstName + " " + this.lastName);
            return true;
        } else if (this.salary > car.getValue() / 12.0) {
            this.car = car;
            System.out.println("Kupiłeś samochód: " + car.producer + " " + car.model);
            System.out.println("Niestety na raty, które wynoszą: " + car.getValue() / 12.0);
            System.out.println("Przypisano do właściela: " + this.firstName + " " + this.lastName);
            return true;
        } else {
            System.out.println("Niestety samochód: " + car.producer + " " + car.model + "jest za drogi");
            return false;
        }
    }

}
