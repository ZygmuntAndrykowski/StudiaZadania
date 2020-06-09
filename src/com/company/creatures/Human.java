package com.company.creatures;

import com.company.devices.Car;
import com.company.devices.Phone;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Human extends Animal {
    private static final Double DEFAULT_SALARY_VALUE = 1700.0;
    private static final Integer DEFAULT_GARAGE_LIMIT = 3;
    public String firstName;
    public String lastName;
    public Animal pet;
    public Double cash = 9000.0;
    public Car[] garage;
    private Double salary = DEFAULT_SALARY_VALUE;

    //private Car[] garage = new Car[DEFAULT_GARAGE_LIMIT];
    private Phone phone = null;


    public Human(String species, int garageLimit) {
        super(species);
        this.garage = new Car[garageLimit];
    }

    public String toString() {
        return this.firstName + " " + this.lastName;
    }

    public Double getSalary() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Data: " + dateFormat.format(date) + ", wartość wypłaty: " + this.salary);
        return this.salary;
    }

    public boolean setSalary(Double value) {
        if (value < 0) {
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

    public Double getCash() {
        return this.cash;
    }

    public Car getCar(int selectPlace) {
        return this.garage[selectPlace];
    }

    public void setCar(Car car, int selectPlace) {
        this.garage[selectPlace] = car;
    }

    public Double valueGarage() {
        Double sumGarageInCar = 0.0;
        for (Car car : garage) {
            if (car != null) sumGarageInCar += car.value;
        }
        return sumGarageInCar;
    }

    public int freeGaragePlace() {

        for (int i = 0; i == this.garage.length; i++) {
            if (this.garage[i] == null) {
                return i;
            }

        }
        return -1;
    }

    public Car[] getGarage() {
        return this.garage;
    }

    public Phone getPhone() {
        return this.phone;
    }

    public Phone setPhone(Phone phone) {
        this.phone = phone;
        return phone;
    }

    public Animal getAnimal() {
        return this.pet;
    }

    public Animal setAnimal(Animal pet) {
        this.pet = pet;
        return pet;
    }


    public boolean buyCarFromSalon(Car car, int selectPlace) {
        if (this.cash > car.getValue()) {
            this.garage[selectPlace] = car;
            System.out.println("Kupiłeś samochód za gotówkę: " + this.garage[selectPlace].toString());
            System.out.println("Przypisano do właściela: " + this.toString());
            return true;
        } else if (this.cash > car.getValue() / 12.0) {
            this.garage[selectPlace] = car;
            System.out.println("Kupiłeś samochód: " + this.garage[selectPlace].toString());
            System.out.println("Niestety na raty, które wynoszą: " + car.getValue() / 12.0);
            System.out.println("Przypisano do właściela: " + this.toString());
            return true;
        } else {
            System.out.println("Niestety samochód: " + car.toString() + "jest za drogi");
            return false;
        }

    }


    @Override
    public void feed() {
        if (this.weight <= 0.0) System.out.println("Nie może jesć jest martwy. ");
        else if (this.weight <= 100.0) {
            this.weight += 1.0;
            System.out.println("Omnomnomnom, " + this.toString() + " waży teraz: " + this.weight);
        }
    }

    @Override
    public void feed(Double foodWeight) {
    }
}
