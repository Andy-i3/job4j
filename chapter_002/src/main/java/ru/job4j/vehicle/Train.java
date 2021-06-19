package ru.job4j.vehicle;

public class Train implements Vehicle{
    private final String name;

    public Train(String n) {
        this.name = n;
    }

    @Override
    public void move() {
        System.out.println("Едет по рельсам");
    }

    @Override
    public void name() {
        System.out.println(name);
    }
}
