package ru.job4j.loop;

public class Board {
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int y=0;y<height;y++) {
            for (int x=y%2;x<width;x++) {
                if (x%2 == 0) {
                    screen.append( "X" );
                   } else {
                    screen.append( " " );
                }
            }
            if(y%2 == 1) screen.append( " " );
            screen.append( ln );
        }
        return screen.toString();
    }
}
