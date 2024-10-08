package oct_7;

import java.util.*;

public class ValidComb {

    static final int MOD = 998244353;

    public static int validCombinations(int A, int B, int C) {
        int totalValid = 0;

        int totalCombinations = (int) Math.pow(B, A);
        for (int mask = 0; mask < totalCombinations; mask++) {
            // Convert the current number (mask) to a sequence of length A using base B
            int[] sequence = convertToBaseB(mask, A, B);

            if (isValid(sequence, C)) {
                totalValid = (totalValid + 1) % MOD;
            }
        }

        return totalValid;
    }

    private static int[] convertToBaseB(int mask, int A, int B) {
        int[] sequence = new int[A];

        for (int i = 0; i < A; i++) {
            sequence[i] = mask % B;
            mask /= B;
        }

        return sequence;
    }

    private static boolean isValid(int[] sequence, int C) {
        int diffCount = 0;

        for (int i = 1; i < sequence.length; i++) {
            if (sequence[i] != sequence[i - 1]) {
                diffCount++;
            }
        }
        return diffCount == C;
    }

    public static void main(String[] args) {
        int A = 3;
        int B = 2;
        int C = 1;

        System.out.println(validCombinations(A, B, C));
    }
}
