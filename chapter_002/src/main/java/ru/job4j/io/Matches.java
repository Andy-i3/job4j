package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        int nummatches = 11;
        boolean item = true;
        while (run) {
            if (item) {
                System.out.println("Первый игрок:");
                item = false;

            } else {
                System.out.println("Второй игрок:");
                item = true;
            }
            int select = Integer.valueOf(input.nextLine());
            if (select > 3 || select < 0) {
                System.out.println("Данные введены неверно");
                item = !item;
            } else {
                nummatches -= select;
                if (nummatches < 0) {
                    nummatches = 0;
                }
            }
            System.out.println("Осталось " + nummatches + " спичек");
            if (nummatches <= 0) {
                run = false;
            }
        }
        if (!item) {
            System.out.println("Выйграл первый игрок");

        } else {
            System.out.println("Выйграл второй игрок");
        }
    }
}