package ru.job4j.loop;

public class Mortgage {

    public static int year(double amount, double salary, double percent) {
        int year = 0;
        double credit_end_year;
        while (amount>0) {
            year++;
            credit_end_year = amount + amount * (percent/100);
            amount = credit_end_year - salary;
        }
        return year;
    }
}
