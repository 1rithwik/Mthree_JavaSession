package main.sep_18;

class Hello_world {
    public void display() {
        int a = 10;
        a++;
        System.out.println(a);
    }

    public static void main(String[] args) {
        Hello_world obj1 = new Hello_world();
        obj1.display();
        int a = 10;
        int b = 20;
        int c = a + b;
        double d = 10.5;
        float f = 20.5f;
        char g = 'g';
        byte h = 100;
        short i = 200;
        long j = 1000000000000000000l;
        boolean k = true;
        String l = "Hello World";
        System.out.println("The sum of a and b is " + c);
        // System.out.println("Hello World");
    }
}