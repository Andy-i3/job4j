package ru.job4j.array;

/*
 * MatrixCheck.
 * @author Golubkov Andrey
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i][i] != data[0][0] || data[i][data.length - i - 1] != data[0][data.length - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}