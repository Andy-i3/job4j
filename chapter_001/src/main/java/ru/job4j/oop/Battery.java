package ru.job4j.oop;

public class Battery {

    private int load;
    public Battery(int load) {
        this.load = load;
    }

    public static void main(String[] args) {

        Battery first = new Battery(10);
        Battery second = new Battery(15);
        System.out.println("First battery = " + first.load + " Second battry = "  + second.load);
        first.exchange(second);
        System.out.println("First battery = " + first.load + " Second battry = "  + second.load);
            }

    public void exchange(Battery another) {

            another.load = another.load + this.load;
            this.load = 0;


        }
}
