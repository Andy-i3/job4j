package ru.job4j.array;

/*
 * FindLoop
 * @author Golubkov Andrey
 * @version $Id$
 * @since 0.1
 * если элемента нет в массиве, то возвращаем -1.
 */
public class FindLoop {
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}