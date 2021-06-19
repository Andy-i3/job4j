package ru.job4j.vehicle;

public class Plane implements Vehicle{
    private final String name;

    public Plane(String n) {
        
        this.name = n;
        
        
    }

    @Override
    public void move() {
        System.out.println("Летает по воздуху");

    }

    @Override
    public void name() {
        System.out.println(name);
    }
}
