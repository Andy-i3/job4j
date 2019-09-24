package ru.job4j.io;

import java.util.Scanner;


public class Matches {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        int nummatches = 11;
        int item = 1;
        while (run) {
            if (item == 1) {
                System.out.println("Первый игрок:");
                item = 0;

            } else {
                System.out.println("Второй игрок:");
                item = 1;
            }
            int select = Integer.valueOf(input.nextLine());
            nummatches -= select;
        }
    }
}

