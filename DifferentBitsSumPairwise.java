// We define f(X, Y) as the number of different corresponding bits in the binary representation of X and Y.
// For example, f(2, 7) = 2, since the binary representation of 2 and 7 are 010 and 111, respectively. 
// The first and the third bit differ, so f(2, 7) = 2.
// You are given an array of N positive integers, A1, A2,..., AN. 
// Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 10^9+7.

// 1 <= N <= 10^5

// 1 <= A[i] <= 2^31 - 1

class Solution {
    public int cntBits(ArrayList<Integer> A) {
        long totalElements = A.size();
        int mod = 1000 * 1000 * 1000 + 7; 
        long sum = 0;
        for(int i = 0; i < 32; i++) {
            long countOfSetBitsAtIthPosition = 0;
            for(int x : A) {
                if(isBitSetAtIthPosition(x, i)) {
                    countOfSetBitsAtIthPosition++;
                }
            }
            long countOfUnsetBitsAtIthPosition = totalElements - countOfSetBitsAtIthPosition;
            long countOfPairsWithDifferentBits = countOfSetBitsAtIthPosition * countOfUnsetBitsAtIthPosition;
            countOfPairsWithDifferentBits *= 2; //to consider pair reversal (1, 3) and (3, 1)
            sum = (sum + countOfPairsWithDifferentBits) % mod;
        }
        return (int) sum;
    }

    private boolean isBitSetAtIthPosition(long x, long position) {
        return (x & (1 << position)) > 0;
    }
}
