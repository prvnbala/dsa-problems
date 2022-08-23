// Given a matrix of integers A of size N x M and an integer B.
// In the given matrix every row and column is sorted in increasing order. Find and return the position of B in the matrix in the given form:
// If A[i][j] = B then return (i * 1009 + j)
// If B is not present return -1.

// Note 1: Rows are numbered from top to bottom and columns are numbered from left to right.
// Note 2: If there are multiple B in A then return the smallest value of i*1009 +j such that A[i][j]=B.

// 1 <= N, M <= 1000
// -100000 <= A[i] <= 100000
// -100000 <= B <= 100000

import java.util.ArrayList;

public class SearchInRowWiseAndColumnWiseSortedMatrix {
    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int lastIndex = A.get(0).size() - 1;
        for (int i = 0; i < A.size(); i++) {
            int firstValue = A.get(i).get(0);
            int lastValue = A.get(i).get(lastIndex);

            if (B >= firstValue && B <= lastValue) {
                //found the row, that can potentially have B
                int j = binarySearch(A.get(i), B);
                if (j == -1) {
                    continue;
                } else {
                    return ((i + 1) * 1009 + (j + 1));
                }
            }
        }
        return -1;
    }

    private int binarySearch(ArrayList<Integer> array, int target) {
        int l = 0;
        int r = array.size() - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int guessValue = array.get(mid);
            if (guessValue == target) {
                ans = mid;
                r = mid - 1;
            } else if (guessValue < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
