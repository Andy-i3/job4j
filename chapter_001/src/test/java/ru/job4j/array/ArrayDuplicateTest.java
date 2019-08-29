package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayDuplicateTest {

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] expectedResult = {"Привет", "Мир", "Привет",
                "Супер", "Мир", "Привет",
                "Супер", "Супер", "Супер",
                "Супер", "Супер", "Мир", "Привет",
                "Супер", "Мир", "Привет",
                "Супер", "Супер", "Супер",
                "Супер", "Супер", "Мир", "Привет"};
        String[] result = {"Привет", "Мир", "Супер"};
        ArrayDuplicate tresult = new ArrayDuplicate();
        expectedResult = tresult.remove(expectedResult);
        Assert.assertArrayEquals(expectedResult, result);
    }
}


