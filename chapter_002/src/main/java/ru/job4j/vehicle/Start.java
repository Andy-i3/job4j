package ru.job4j.vehicle;

public class Start {

    public static void main(String[] args) {

        Vehicle bus = new Bus("автобус");
        Vehicle train = new Train("поезд");
        Vehicle plane = new Plane("самолет");

        Vehicle[] transport = new Vehicle[]{bus,train,plane};
        for (Vehicle a : transport) {
            a.name();
            a.move();

        }

    }

}
