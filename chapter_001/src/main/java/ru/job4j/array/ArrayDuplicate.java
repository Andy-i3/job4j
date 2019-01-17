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
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                if (array[i] == array[j]) {
                    array[j] = array[array.length - 1];
                    array = Arrays.copyOf(array, (array.length - 1));
                    j--;
                }

            }
        }
        return array;

    }
}
