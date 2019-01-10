package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        int[] expectedResult = {9, 1, 5, 4, 2, 3, 9, 7, 8, 0, 6, 5, 9};
        int[] result = {0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 9, 9};
        expectedResult = BubbleSort.sort(expectedResult);
        Assert.assertArrayEquals(expectedResult, result);
    }
}