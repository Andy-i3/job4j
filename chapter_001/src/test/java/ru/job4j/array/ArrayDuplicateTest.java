package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
        ArrayDuplicate Result = new ArrayDuplicate();
        expectedResult = Result.remove(expectedResult);
        Assert.assertArrayEquals(expectedResult, result);
    }
}