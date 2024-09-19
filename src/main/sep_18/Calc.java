package main.sep_18;

public class Calc {
    int a;
    int b;

    void add(int a, int b) {
        int res = a + b;
        System.out.println("Addition of " + a + " and " + b + " is " + res);
    }

    void sub(int a, int b) {
        int res = a - b;
        System.out.println("Subtraction of " + a + " and " + b + " is " + res);
    }

    void mul(int a, int b) {
        int res = a * b;
        System.out.println("Multiplication of " + a + " and " + b + " is " + res);
    }

    void div(int a, int b) {
        int res = a / b;
        System.out.println("Division of " + a + " and " + b + " is " + res);
    }

    void mod(int a, int b) {
        int res = a % b;
        System.out.println("Modulus of " + a + " and " + b + " is " + res);
    }

    void pow(int a, int b) {
        int res = (int) Math.pow(a, b);
        System.out.println("Power of " + a + " and " + b + " is " + res);
    }

    void sqrt(int a) {
        int res = (int) Math.sqrt(a);
        System.out.println("Square root of " + a + " is " + res);
    }

    void cube(int a) {
        int res = (int) Math.pow(a, 3);
        System.out.println("Cube of " + a + " is " + res);
    }

    void square(int a) {
        int res = (int) Math.pow(a, 2);
        System.out.println("Square of " + a + " is " + res);
    }

    public static void main(String[] args) {
        Calc cal = new Calc();
        cal.add(130, 20);
        cal.sub(101, 20);
        cal.mul(14, 5);
        cal.div(146, 15);
        cal.mod(140, 10);
        cal.pow(13, 4);
        cal.sqrt(120);
        cal.cube(27);
        cal.square(150);
    }
}
