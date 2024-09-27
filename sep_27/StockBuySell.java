package sep_27;

import java.util.*;

public class StockBuySell {
    static void fun1(int[] arr) {
        int currmin = arr[0];
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            currmin = Math.min(currmin, arr[i]);
            res = Math.max(res, arr[i] - currmin);
        }
        System.out.println("The maximum profit is " + res);
    }

    public static void main(String[] args) {

        System.out.println("Enter the size of the array");
        int[] arr = { 7, 1, 2, 6, 4, 5 };
        fun1(arr);
    }
}
