// Write a program to input an integer N from user and print pascal triangle up to N rows.
// 1 <= N <= 25

import java.util.ArrayList;
import java.util.Collections;

public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            ArrayList<Integer> row = new ArrayList<>(Collections.nCopies(A, 0));
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.set(j, 1);
                } else {
                    int val = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                    row.set(j, val);
                }
            }
            result.add(row);
        }
        return result;
    }
}
