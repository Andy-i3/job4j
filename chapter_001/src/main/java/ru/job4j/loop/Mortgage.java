package ru.job4j.loop;

public class Mortgage {

    public static int year(double amount, double salary, double percent) {
        int year = 0;
        double creditEndYear;
        while (amount > 0) {
            year++;
            creditEndYear = amount + amount * (percent / 100);
            amount = creditEndYear - salary;
        }
        return year;
    }
}
