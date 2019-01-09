package ru.job4j.array;

public class BubbleSort {

    public static int[] sort(int[] array) {

        int buf = 0;
        for (int j = 0; j < array.length - 1; j++) {
            int f = 0;
            for (int i = 0; i < array.length - j; i++) {
                if (array[i] > array[i + 1]) {
                    buf = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = buf;
                    f = 1;
                }
            }
        }
    return array;
        }
}
