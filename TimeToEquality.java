// Given an integer array A of size N. In one second, you can increase the value of one element by 1.
// Find the minimum time in seconds to make all elements of the array equal.
// 1 <= N <= 1000000
// 1 <= A[i] <= 1000

import java.util.ArrayList;
import java.util.Collections;

class TimeToEquality {
    public int solve(ArrayList<Integer> A) {
        int maxValue = Collections.max(A);
        int result = 0;
        for (int x : A) {
            result += (maxValue - x);
        }
        return result;
    }
}
