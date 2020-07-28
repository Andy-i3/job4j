package ru.job4j.array;

/*
 * Turn.
 * @author Golubkov Andrey
 * @version $Id$
 * @since 0.1
 */
public class Turn {
    public int[] back(int[] array) {
        int buf = 0;
        for (int idx = 0; idx < (array.length / 2); idx++) {
            buf = array[idx];
            array[idx] = array[array.length - idx - 1];
            array[array.length - idx - 1] = buf;
        }
        return array;
    }
}