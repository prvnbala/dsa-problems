// Given an array of integers A of size, N. 
// Find the longest subsequence of A, which is odd-even.

// A subsequence is said to be odd-even in the following cases:

// The first element of the subsequence is odd; 
// the second element is even, the third element is odd, and so on. 
// For example: [5, 10, 5, 2, 1, 4], [1, 2, 3, 4, 5]

// The first element of the subsequence is even, 
// the second element is odd, the third element is even, and so on. 
// For example: [10, 5, 2, 1, 4, 7], [10, 1, 2, 3, 4]

// Return the maximum possible length of odd-even subsequence.

// Note: An array B is a subsequence of an array A 
// if B can be obtained from A by deleting several 
// (possibly, zero, or all) elements.

// 1 <= N <= 100000
// 1 <= A[i] <= 10^9 

class OddEvenSubsequences {
    public int solve(ArrayList<Integer> A) {
        int lengthOfSubsequenceWithOddStart = 0;
        int lengthOfSubsequenceWithEvenStart = 0;

        for(int i = 0; i < A.size(); i++) {
            int number = A.get(i);
            if(isOdd(number) && lengthOfSubsequenceWithOddStart == 0) {
                lengthOfSubsequenceWithOddStart = findOddEvenSubsequence(A, i);
            } 
            
            if(! isOdd(number) && lengthOfSubsequenceWithEvenStart == 0) {
                lengthOfSubsequenceWithEvenStart = findOddEvenSubsequence(A, i);
            } 

            if(lengthOfSubsequenceWithOddStart != 0 && lengthOfSubsequenceWithEvenStart != 0) {
                break;
            }
        }

        return Math.max(lengthOfSubsequenceWithOddStart, lengthOfSubsequenceWithEvenStart);
    }

    private int findOddEvenSubsequence(ArrayList<Integer> list, int startPosition) {
        int startValue = list.get(startPosition);
        boolean needOdd = !isOdd(startValue);
        
        int length = 1;
        for(int i = startPosition + 1; i < list.size(); i++) {
            int number = list.get(i);
            if(isOdd(number) && needOdd) {
                length++;
                needOdd = false;
            } else if(!isOdd(number) && !needOdd) {
                length++;
                needOdd = true;
            }
        }
        return length;
    }

    private boolean isOdd(int number) {
        return (number % 2) != 0; 
    }
}
