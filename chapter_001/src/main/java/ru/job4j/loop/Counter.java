package ru.job4j.loop;

/**
 * @author Golubkov Andrey
 * @version $Id$
 * @since 0.1
 */

public class Counter {
    public int add(int start, int finish) {
        int count = 0;
        for (int i = start; i <= finish; i++) {
            if ((i % 2) == 0) {
                count = i + count;
            }
        }
        return count;
    }
}
