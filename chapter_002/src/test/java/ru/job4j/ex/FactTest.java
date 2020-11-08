package ru.job4j.ex;

import org.junit.Test;

public class FactTest {

    @Test (expected = IllegalArgumentException.class)
    public void calc() {
        Fact d = new Fact();
        d.calc(-10);
    }
}