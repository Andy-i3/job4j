package ru.job4j.array;

/*
 * Matrix
 * @author Golubkov Andrey
 * @version $Id$
 * @since 0.1
 */
public class Matrix {
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (j + 1) * (i + 1);
            }
        }
        return table;
    }
}