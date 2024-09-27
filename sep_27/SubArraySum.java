package sep_27;

import java.util.HashMap;
import java.util.ArrayList;

public class SubArraySum {
    static void findSubarrays(int[] arr, int target) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<int[]> result = new ArrayList<>();
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if (currSum == target) {
                result.add(new int[] { 0, i }); // Subarray from start to current index
            }

            if (map.containsKey(currSum - target)) {
                for (int startIndex : map.get(currSum - target)) {
                    result.add(new int[] { startIndex + 1, i }); // Subarray from startIndex+1 to current index
                }
            }

            map.putIfAbsent(currSum, new ArrayList<>());
            map.get(currSum).add(i);
        }

        for (int[] subarray : result) {
            System.out.println("Subarray found from index " + subarray[0] + " to " + subarray[1]);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 7, 5 };
        int target = 12;
        findSubarrays(arr, target);
    }
}
