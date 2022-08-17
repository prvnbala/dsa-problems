// Given an array of integers A, calculate the sum of A [ i ] % A [ j ] for all possible i, j pairs. 
// Return sum % (10^9 + 7) as an output.

// 1 <= length of the array A <= 10^5
// 1 <= A[i] <= 10^3

class Solution {
    public int solve(ArrayList<Integer> A) {
        int mod = 1000 * 1000 * 1000 + 7;
        int[] frequencyArray = createFrequencyArray(A);
        long result = 0;

        for(int i = 1; i < frequencyArray.length; i++) {
            for(int j = 1; j < frequencyArray.length; j++) {
                long val = i % j; //i and j actually represent nums, frequencyArray[i] reps freq of i; 
                result = (result + val * frequencyArray[i] * frequencyArray[j]) % mod;
            }
        }
        return (int) result;
    }

    private int[] createFrequencyArray(ArrayList<Integer> A) {
        int arraySize = Collections.max(A) + 1;
        int[] frequencyArray = new int[arraySize];
        for(int x : A) {
            frequencyArray[x]++;
        }
        return frequencyArray;
    }
}
