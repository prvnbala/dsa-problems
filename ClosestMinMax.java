// Given an array A, find the size of the smallest subarray such that
// it contains at least one occurrence of the maximum value of the array
// and at least one occurrence of the minimum value of the array.

// 1 <= |A| <= 2000


import java.util.ArrayList;
import java.util.Collections;

public class ClosestMinMax {
    public int solve(ArrayList<Integer> A) {
        int minimumValue = Collections.min(A);
        int maximumValue = Collections.max(A);

        int minimumIndex = -1;
        int maximumIndex = -1;

        int distance = Integer.MAX_VALUE;

        for (int i = 0; i < A.size(); i++) {
            int value = A.get(i);

            if (value == minimumValue) {
                minimumIndex = i;
            }

            if (value == maximumValue) {
                maximumIndex = i;
            }

            if (minimumIndex != -1 && maximumIndex != -1) {
                distance = Math.min(distance, Math.abs(minimumIndex - maximumIndex));
            }
        }

        return distance + 1;
    }
}
