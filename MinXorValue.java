// Given an integer array A of N integers, 
// find the pair of integers in the array which have minimum XOR value. 
// Report the minimum XOR value.

// 2 <= length of the array <= 100000
// 0 <= A[i] <= 10^9

import java.util.ArrayList;
import java.util.Collections;

class MinXorValue {
    public int findMinXor(ArrayList<Integer> A) {
        int minXor = Integer.MAX_VALUE;
        Collections.sort(A);
        for (int i = 1; i < A.size(); i++) {
            int currentElement = A.get(i);
            int previousElement = A.get(i - 1);
            minXor = Math.min(minXor, previousElement ^ currentElement);
        }
        return minXor;
    }
}
