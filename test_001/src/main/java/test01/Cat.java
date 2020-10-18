package test01;

/**
 *
 */
public class Cat extends Animal{

    public static int getCcCat() {
        return CC_CAT;
    }

    private static final int CC_CAT = 100;

    private int A = 0;
    public Cat(int A) {

       this.A = A;
   }

    public int getA() {
        return A;
    }
}
