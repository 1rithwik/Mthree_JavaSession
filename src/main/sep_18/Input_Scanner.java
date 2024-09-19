package main.sep_18;

import java.util.Scanner;

public class Input_Scanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if (a % 2 == 0) {
            System.out.println(" Number is Even");
        } else {
            System.out.println(" Number is Odd");
        }
    }
}