package sep_25.datastructures;

import java.util.*;

public class TwoSumArr {
    static void fun1(HashMap<Integer, Integer> map, int target) {
        for (int i : map.keySet()) {
            int complement = target - i;
            if (map.containsKey(complement)) {
                System.out.println("The indices are " + map.get(i) + " and " + map.get(complement));
            }
        }
    }

    static void fun2(int[] arr, int target) {
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        while (l < r) {
            if (arr[l] + arr[r] == target) {
                System.out.println("The indices are " + l + " and " + r);
            } else if (arr[l] + arr[r] > target) {
                r--;
            } else {
                l++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            map.put(sc.nextInt(), i);
        }
        System.out.println("Enter the target sum");
        int target = sc.nextInt();
        fun1(map, target);
        fun2(null, target);
        sc.close();
    }

}
