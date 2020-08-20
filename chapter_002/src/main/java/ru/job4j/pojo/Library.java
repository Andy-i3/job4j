package ru.job4j.pojo;

import java.awt.print.Printable;

public class Library {
    public static void main(String[] args) {

        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = new Book();

        book1.setName("One");
        book2.setName("Two");
        book3.setName("Three");
        book4.setName("Clean Code");

        book1.setPage(10);
        book2.setPage(4);
        book3.setPage(54);
        book4.setPage(1);

        Book[] books = new Book[4];

        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;

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
