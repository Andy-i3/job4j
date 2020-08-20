package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {

        Student student = new Student();
        student.setName("Alex");
        student.setGroup("m5");
        Date date = new Date();
        date.setDate(22);
        date.setMonth(3 - 1);
        date.setYear(2020 - 1900);
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        student.setData(date);
        System.out.println("Name: " + student.getName());
        System.out.println("Group: " + student.getGroup());
        System.out.println("Data: " + student.getData().toString());

    }
}
