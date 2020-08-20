package ru.job4j.pojo;

import java.awt.print.Printable;

public class Library {
    public static void main(String[] args) {

        Book[] books = new Book[4];
        books[0] = new Book("One",10);
        books[1] = new Book("Two",15);
        books[2] = new Book("Three",54);
        books[3] = new Book("Clean Code",1);

        print(books);

        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;

        print(books);
        printclc(books);
    }

    private static void print (Book[] books) {

        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " -- " + books[index].getPage());
        }
        System.out.println();
    }

    private static void printclc (Book[] books) {

        for (int index = 0; index < books.length; index++) {
            if (books[index].getName().equals("Clean Code")) {
                System.out.println(books[index].getName() + " -- " + books[index].getPage());
            }
        }
        System.out.println();
    }

}
