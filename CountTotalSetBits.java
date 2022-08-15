// Given a positive integer A, the task is to count the total number of set bits in the binary representation of all the numbers from 1 to A.
// Return the count modulo 10^9 + 7.

// 1 <= A <= 10^9

class Solution {
    private final int MOD = 1000 * 1000 * 1000 + 7;

    public int solve(int A) {
        A++;
        long totalOnes = 0;
        long powerOfTwo = 1;
        while (powerOfTwo <= A) {
            long totalZeroOnePairs = A / powerOfTwo;
            long totalOnePairs = totalZeroOnePairs / 2;
            totalOnes = (totalOnes + (totalOnePairs * powerOfTwo)) % MOD;

            if (isOdd(totalZeroOnePairs)) {
                totalOnes = (totalOnes + (A % powerOfTwo)) % MOD;
            }
            powerOfTwo *= 2;
        }

        return (int) totalOnes;
    }

    private boolean isOdd(long number) {
        return number % 2 != 0;
    }
}
