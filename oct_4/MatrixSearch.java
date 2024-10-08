package oct_4;

import java.util.*;

public class MatrixSearch {
    static void search(int[][] arr, int n, int key) {
        int res = 0, row_no = 0;
        for (int[] row : arr) {
            res = Arrays.binarySearch(row, key);
            if (res > 0) {
                break;
            }
            row_no++;
        }
        System.out.println("Found at:" + res + "in the row " + row_no);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = 3, key = 16;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.nextInt();
            }
        }
        s.close();
        search(arr, n, key);
    }
}
