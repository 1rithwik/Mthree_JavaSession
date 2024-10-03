package oct_3;

public class CoinDp {
    static void fun1(int[] coins, int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (coins[i] <= j)
                    arr[j] += arr[j - coins[i]];
            }
        }
        System.out.println(arr[n]);
    }

    public static void main(String[] args) {
        int[] coins = { 2, 3, 5 };
        int n = 12;
        fun1(coins, n);
    }
}
