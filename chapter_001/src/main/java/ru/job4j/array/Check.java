package ru.job4j.array;

/*
 * Check.
 * @author Golubkov Andrey
 * @version $Id$
 * @since 0.1
 */

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int idx = 0; idx < data.length - 1; idx++) {
            if (data[idx] != data[idx + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}