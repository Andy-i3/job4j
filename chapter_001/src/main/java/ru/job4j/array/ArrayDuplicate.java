package ru.job4j.array;

import java.util.Arrays;

/*
 * ArrayDuplicate
 * @author Golubkov Andrey
 * @version $Id$
 * @since 0.1
 */

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int flag = 0;
        String buf;
        for (int i = 0; i < array.length - 1 - flag; i++) {
            for (int j = i; j < array.length - 1 - flag; j++) {
                if (array[i].equals( array[j + 1] )) {
                    buf = array[j + 1];
                    array[j + 1] = array[array.length - 1 - flag];
                    array[array.length - 1 - flag] = buf;
                    flag++;
                    j--;
                }
            }
        }
        array = Arrays.copyOf(array, (array.length - flag));
        return array;
    }
}
