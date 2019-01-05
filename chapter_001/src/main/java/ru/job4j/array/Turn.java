package ru.job4j.array;

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