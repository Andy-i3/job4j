package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter {
    /**
     * Конвертируем рубли в евро.     *
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / 70;
    }

    /**
     * Конвертируем евро в рубли.     *
     * @param value Евро.
     * @return рубли.
     */
    public int euroToRuble(int value) {
        return 70 * value;
    }

    /**
     * Конвертируем рубли в доллары.     *
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return value / 60;
    }

    /**
     * Конвертируем доллары в рубли.     *
     * @param value Доллары.
     * @return Рубли
     */
    public int dollarToRuble(int value) {
        return 60 * value;
    }

}