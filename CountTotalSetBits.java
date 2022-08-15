// Given a positive integer A, the task is to count the total number of set bits in the binary representation of all the numbers from 1 to A.
// Return the count modulo 10^9 + 7.

// 1 <= A <= 10^9

class Solution {

    public int solve(int A) {
        A++;
        long totalOnes = 0;
        long pairSize = 1; //power of 2
        while (pairSize <= A) {
            long totalZeroOnePairs = A / pairSize;
            long totalOnePairs = totalZeroOnePairs / 2;
            int mod = 1000 * 1000 * 1000 + 7;
            totalOnes = (totalOnes + (totalOnePairs * pairSize)) % mod;

            if (isOdd(totalZeroOnePairs)) {
                totalOnes = (totalOnes + (A % pairSize)) % mod;
            }
            pairSize *= 2;
        }

        return (int) totalOnes;
    }

    private boolean isOdd(long number) {
        return number % 2 != 0;
    }
}
