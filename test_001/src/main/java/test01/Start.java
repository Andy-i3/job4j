package test01;

public class Start {

    public static void main(String[] args) {

        Animal cat = new Cat(25);
        Dog dog = new Dog(36);
        Animal mouse = new Mouse(54);
        Mouse m1 = (Mouse) mouse;
        System.out.println(m1.getC());
        cat.run();
        dog.stop();
        mouse.wolk();
    }

}
