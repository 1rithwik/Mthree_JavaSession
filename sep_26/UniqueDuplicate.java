package sep_26;

import java.util.*;

public class UniqueDuplicate {
    static int fun1(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int k = set.size();
        int j = 0;
        for (int a : set) {
            arr[j++] = a;
        }
        return k;
    }

    static void fun2(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                arr[i + 1] = arr[j];
                i++;
            }
        }
        for (int z = 0; z < arr.length; z++) {
            System.out.println(arr[z] + " ");
        }
    }

    static void fun3(int[] arr) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            arr[index] = entry.getKey();
            index++;
        }
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            while (entry.getValue() > 1) {
                arr[index] = entry.getKey();
                index++;
                entry.setValue(entry.getValue() - 1);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 1, 2, 2, 3, 3 };
        int k = fun1(arr);
        for (int i = 0; i < k; i++) {
            System.out.println(arr[i] + " ");
        }
        fun2(arr);
        // fun3(arr);
    }
}
