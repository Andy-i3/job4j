package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {

    public String ask(String msg) {

        System.out.println(msg);
        Scanner in = new Scanner(System.in);
        return in.next();
    }
}
