// Given a binary string A. It is allowed to do at most one swap between any 0 and 1.
// Find and return the length of the longest consecutive 1’s that can be achieved.
// 1 <= length of string <= 1000000
// A contains only characters 0 and 1.


public class LengthOfLongestConsecutiveOnes {
    public int solve(String A) {
        // pre-processing
        int[] prefixSum = findPrefixSumOnBinaryStringWithSumResetOnEveryZero(A);
        int[] postfixSum = findPostfixSumOnBinaryStringWithSumResetOnEveryZero(A);

        return findLengthOfLongestConsequtiveOnesWithAtmostOneDeviation(A, prefixSum, postfixSum);
    }

    private int findFrequencyOfCharacterInString(String input, char target) {
        int frequency = 0;
        for(char x : input.toCharArray()) {
            if (x == target) {
                frequency++;
            }
        }
        return frequency;
    }

    private int[] findPrefixSumOnBinaryStringWithSumResetOnEveryZero (String input) {
        int size = input.length();
        int[] prefixSum = new int[size];
        for(int i = 0; i < size; i++) {
            char x = input.charAt(i);
            int num = Character.getNumericValue(x);
            if(num == 1) {
                int previousSum = i == 0 ? 0 : prefixSum[i - 1];
                prefixSum[i] = previousSum + num;
            } else {
                prefixSum[i] = 0; // redundant, added for clarity.
            }
        }
        return prefixSum;
    }

    private int[] findPostfixSumOnBinaryStringWithSumResetOnEveryZero(String input) {
        int size = input.length();
        int[] postfixSum = new int[size];
        for(int i = size - 1; i >= 0; i--) {
            char x = input.charAt(i);
            int num = Character.getNumericValue(x);
            if(num == 1) {
                int postValue = i == size - 1 ? 0 : postfixSum[i + 1];
                postfixSum[i] = postValue + num;
            } else {
                postfixSum[i] = 0; // redundant, added for clarity.
            }
        }
        return postfixSum;
    }

    private int findLengthOfLongestConsequtiveOnesWithAtmostOneDeviation(String A, int[] prefixSum, int[] postfixSum) {
        int totalOnes = findFrequencyOfCharacterInString(A, '1');
        int longestConsequtiveOnes = Integer.MIN_VALUE;
        for(int i = 0; i < A.length(); i++) {
            int numberAtI = Character.getNumericValue(A.charAt(i));
            int oneCountOnLeft = i == 0 ? 0 : prefixSum[i - 1];
            int oneCountOnRight = i == A.length() - 1 ? 0 : postfixSum[i + 1];
            int consequtiveOnes = oneCountOnLeft + oneCountOnRight; //not final.

            if(numberAtI == 1) {
                consequtiveOnes += 1; //add the current one.
            } else if(isExtraOnePresentForSwap(consequtiveOnes, totalOnes)) {
                consequtiveOnes += 1; //swap one from outside the considered range.
            } else {
                consequtiveOnes += 0; //swap one from considered range.
            }

            longestConsequtiveOnes = Math.max(longestConsequtiveOnes, consequtiveOnes);
        }
        return longestConsequtiveOnes;
    }

    private boolean isExtraOnePresentForSwap(int currentSum, int totalSum) {
        return currentSum < totalSum;
    }
}
