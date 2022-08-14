// You are given an array of integers A of size N.
// Return the difference between the maximum among all even numbers of A and the minimum among all odd numbers in A.

// 2 <= N <= 1e5
// -1e9 <= A[i] <= 1e9
// There is atleast 1 odd and 1 even number in A

class Solution {
    public int solve(ArrayList<Integer> A) {
        int evenMaximum = Integer.MIN_VALUE;
        int oddMinimum = Integer.MAX_VALUE;
        for(int x : A) {
            if(isOdd(x)) {
                oddMinimum = Math.min(oddMinimum, x);
            } else {
                evenMaximum = Math.max(evenMaximum, x);
            }
        }
        return evenMaximum - oddMinimum;
    }
    
    private boolean isOdd(int x) {
        return x % 2 != 0;
    }
}
