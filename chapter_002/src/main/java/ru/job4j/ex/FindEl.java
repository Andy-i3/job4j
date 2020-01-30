package ru.job4j.ex;

public class FindEl {

    public static void main(String[] args) {
        String[] a = {"123", "234", "234"};
        String b = "567";
        try {
            indexOf( a, b );
        } catch (ElementNotFoundException e) {
            System.out.println( e.getStackTrace() );
        }
    }

    public static int indexOf(String[] value, String key) throws ElementNotFoundException{
        int rsl = -1;
        for (String c : value) {
            if (c == key) rsl=0;
        }
        if (rsl == -1) throw new ElementNotFoundException("Error 123");
        return rsl;
    }
}
