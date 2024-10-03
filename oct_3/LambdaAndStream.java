package oct_3;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

/*
 * the stream methods filter, map, sorted, foreach, distinct 
 */
public class LambdaAndStream {
    static void fun1() {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        Arrays.stream(arr).forEach(System.out::println);
        IntStream a1 = Arrays.stream(arr);
        a1.filter(x -> x % 2 == 0).map(x -> x * x).forEach(System.out::println);

        int[] a2 = { 4, 6, 1, 9, 3, 10 };
        List<Integer> l1 = Arrays.stream(a2).boxed().sorted().collect(Collectors.toList());
        for (int i : l1) {
            System.out.println(i);
        }

    }

    public static void main(String[] args) {
        Runnable t1 = () -> System.out.println("Welcome");
        t1.run();

        BiFunction<Double, Double, Double> add = (a, b) -> a + b;
        BiFunction<Double, Double, Double> sub = (a, b) -> a - b;
        BiFunction<Double, Double, Double> mul = (a, b) -> a * b;
        BiFunction<Double, Double, Double> div = (a, b) -> a / b;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number: ");
        double n1 = scanner.nextDouble();

        System.out.println("Enter second number: ");
        double n2 = scanner.nextDouble();

        System.out.println("Choose operation: +, -, *, /");
        char operator = scanner.next().charAt(0);

        scanner.close();
        double res = 0;
        switch (operator) {
            case '+':
                add.apply(n1, n2);
                break;
            case '-':
                res = sub.apply(n1, n2);
                break;
            case '*':
                res = mul.apply(n1, n2);
                break;
            case '/':
                res = div.apply(n1, n2);
                break;
            default:
                System.out.println("Invalid operator!");
                return;
        }
        System.out.println(res);
        fun1();
    }
}
