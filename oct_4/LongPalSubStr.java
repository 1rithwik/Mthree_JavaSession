package oct_4;

public class LongPalSubStr {
    static int fun1(String s) {
        int n = s.length();
        if (n == 0)
            return 0;
        int start = 0, maxLen = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 1; j++) {
                int low = i;
                int high = i + j;
                while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                    int currLen = high - low + 1;
                    if (currLen > maxLen) {
                        start = low;
                        maxLen = currLen;
                    }
                    low--;
                    high++;
                }
            }
        }

        return maxLen;
    }

    static int fun2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        int start = 0;

        for (int i = 0; i < n; ++i)
            dp[i][i] = true;

        for (int i = 0; i < n - 1; ++i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }

        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i < n - k + 1; ++i) {
                int j = i + k - 1;
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;

                    if (k > maxLen) {
                        start = i;
                        maxLen = k;
                    }
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abccb";
        System.out.println(fun1(s));
        System.out.println(fun2(s));
    }
}
