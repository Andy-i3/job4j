package ru.job4j.test;

import java.util.StringJoiner;

class Test {

    public static void main(String[]args) {

        StringJoiner sj = new StringJoiner("/", "prefix-", "-suffix")
                .add("2016")
                .add("02")
                .add("26");




        String result = sj.toString();
        System.out.println(result);

    }
}
