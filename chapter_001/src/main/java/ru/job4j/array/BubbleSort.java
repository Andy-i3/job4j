package ru.job4j.array;

/*
 * BubbleSort.
 * @author Golubkov Andrey
 * @version $Id$
 * @since 0.1
 */

public class BubbleSort {

    public static int[] sort(int[] array) {
        int buf;
        for (int j = 0; j < array.length - 1; j++) {
            boolean f = false;
            for (int i = 0; i < array.length - j - 1; i++) {
                if (array[i] >= array[i + 1]) {
                    buf = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buf;
                    f = true;
                }
            }
            if (!f) {
                break;
            }
        }
        return array;
    }
}
