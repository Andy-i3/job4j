package ru.job4j.poly;

public class Bus implements Transport {

    private int qpassengers;
    private int qrefuel;

    @Override
    public void go() {

    }

    @Override
    public void passengers(int qpassengers) {

        this.qpassengers = qpassengers;

    }

    @Override
    public float refuel(int qrefuel) {

        this.qrefuel = qrefuel;
        float price = (float) (qrefuel * 5.4);
        return price;
    }
}
