package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        Fact h = new Fact();
        System.out.println(h.calc(5));
    }

    public int calc(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Start should be less then finish.");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}