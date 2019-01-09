package ru.job4j.array;

        import org.junit.Test;

        import static org.junit.Assert.assertEquals;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        //напишите здесь тест, проверяющий сортировку массива из 10 элементов методом пузырька, например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
        int[] sgn = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] result = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertEquals( result, BubbleSort.sort( sgn ) );
    }
}