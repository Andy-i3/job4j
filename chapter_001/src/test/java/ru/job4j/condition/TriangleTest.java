package ru.job4j.condition;

import org.junit.Test;
        import static org.hamcrest.number.IsCloseTo.closeTo;
        import static org.junit.Assert.*;

public class TriangleTest {

/*
  1. Создаем три объекта класса Point.
  2. Создаем объект треугольник и передаем в него объекты точек.
  3. Вычисляем площадь.
  4. Задаем ожидаемый результат.
  5. Проверяем результат и ожидаемое значение.
   */

    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        //
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 2D;
        assertThat(result, closeTo(expected, 0.1));
    }
}