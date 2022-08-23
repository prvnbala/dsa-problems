// Given a binary sorted matrix A of size N x N. Find the row with the maximum number of 1.

// NOTE:

// If two rows have the maximum number of 1 then return the row which has a lower index.
// Rows are numbered from top to bottom and columns are numbered from left to right.
// Assume 0-based indexing.
// Assume each row to be sorted by values.
// Expected time complexity is O(rows).

// 1 <= N <= 1000
// 0 <= A[i] <= 1

import java.util.ArrayList;

public class RowWithMaximumNumberOfOnes {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int lastZeroIndex = A.size() - 1;
        int row = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i).get(lastZeroIndex) == 1) {
                row = i;
                while (lastZeroIndex >= 0 && A.get(i).get(lastZeroIndex) == 1) {
                    lastZeroIndex--;
                }
            }
            if (lastZeroIndex == 0) break;
        }
        return row;
    }
}
