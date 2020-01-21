package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactTest {

    @Test (expected = IllegalArgumentException.class)
    public void calc() {
        Fact d = new Fact();
        d.calc(10);
    }
}