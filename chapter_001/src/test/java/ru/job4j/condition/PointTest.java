package ru.job4j.condition;

import org.junit.Test;
import ru.job4j.max.Max;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void distance3d() {
        Point point1 = new Point(2,2,2);
        Point point2 = new Point(3,3,3);
        double result = point1.distance3d(point2);
        assertThat(result, is(1.7320508075688772));
    }

    @Test
    public void distanceTo() {
        Point point1 = new Point(2,2);
        Point point2 = new Point(3,3);
        double result = point1.distanceTo(point2);
        assertThat(result, is(1.4142135623730951));
    }

  }