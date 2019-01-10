package ru.job4j.calculator;

/*
 * Calculator.
 * @author Golubkov Andrey
 * @version $Id$
 * @since 0.1
 */

public class Calculator {
    private double result;
    public void add(double first, double second) {
        this.result = first + second;
    }
    public void subtract(double first, double second) 	{
		this.result = first - second;
    }
    public void div(double first, double second)	{
        this.result = first / second;
    }
    public void multiple(double first, double second)	{
        this.result = first * second;
    }
    public double getResult()	{
        return this.result;
    }
}