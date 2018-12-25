package ru.job4j.loop;

public class Board {
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if ((x + y) % 2 == 0) {
                    screen.append( "X" );
                } else {
                    screen.append( " " );
                }
            }
            screen.append( ln );
        }
        return screen.toString();
    }
}
