package ru.job4j.oop;

public class DummyDic {
    public static void main(String[] args) {
        DummyDic book = new DummyDic();
        String say = book.engToRus("name");
        System.out.println(say);
    }

    public String engToRus(String eng) {
        return "Неизвестное слово. " + eng;
    }
}
