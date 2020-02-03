package ru.job4j.ex;

public class FindEl {

    public static void main(String[] args) {
        String[] a = {"123", "234", "567"};
        String b = "567";
        try {
            System.out.println(indexOf( a, b ));
             } catch (ElementNotFoundException e) {
            System.out.println( e.getStackTrace() );
        }
    }

    public static int indexOf(String[] value, String key) throws ElementNotFoundException{
        int rsl = -1;
        int index = 0;
        for (String c : value) {
             if (c.equals( key )) rsl=index;
            ++index;
        }
        if (rsl == -1) throw new ElementNotFoundException("Error 123");
        return rsl;
    }
}
