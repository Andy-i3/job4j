package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {

        Student student = new Student();
        student.setName("Alex");
        student.setGroup("m5");
        Date date = new Date();
        date.setYear(2020);
        date.setMonth(1);
        date.setDate(22);
        student.setData(date);

        System.out.println("Name: " + student.getName());
        System.out.println("Group: " + student.getGroup());
        Date dateget = student.getData();
        System.out.println("Data: " + dateget.toString());

    }
}
