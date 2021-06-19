package ru.job4j.vehicle;

public class Bus implements Vehicle{

    private final String name;

    public Bus(String n) {
        this.name = n;
    }

    @Override
    public void move() {
        System.out.println("Едет по дороге");

    }

    @Override
    public void name() {
        System.out.println(name);

    }


}
