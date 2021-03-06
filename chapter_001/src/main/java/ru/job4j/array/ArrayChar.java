package ru.job4j.array;

/**
 * Обертка над строкой.
 */

public class ArrayChar {
    private char[] data;
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.     *
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int idx = 0; idx < value.length; idx++) {
            if (this.data[idx] != value[idx]) {
                result = false;
                break;
            }
        }
        return result;
    }
}