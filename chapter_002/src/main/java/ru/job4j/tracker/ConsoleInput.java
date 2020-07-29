package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    @Override
    public String askStr(String msg) {
       System.out.println(msg);
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    @Override
    public int askInt(String question) {
        return Integer.valueOf(askStr(question));
    }

    @Override
    public int askInt(String question, int max) {
        int select = askInt(question);
        if (select >= 0 && select < max) {
            return select;
        } else {
            throw new IllegalStateException(String.format("Out of about %s > [0, %s]", select, max));
        }
    }
}
