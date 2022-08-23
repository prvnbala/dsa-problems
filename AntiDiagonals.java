// Give a N * N square matrix A, return an array of its anti-diagonals.
// Look at the example for more details.
// 1<= N <= 1000
// 1<= A[i][j] <= 1e9


import java.util.ArrayList;
import java.util.List;


public class AntiDiagonals {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        int size = A.size();
        int rowCount = (2 * size) - 1;
        int[][] result = new int[rowCount][size];

        int top = 0, right = size - 1, bottom = size - 1, left = 0;

        for (int i = 0; i < size; i++) {
            List<Integer> valuesForCurrentColumn = new ArrayList<>();

            //reading the top row values
            for (int j = left; j <= right; j++) {
                int val = A.get(top).get(j);
                valuesForCurrentColumn.add(val);
            }
            top++;

            //reading the right column values
            for (int j = top; j <= bottom; j++) {
                int val = A.get(j).get(right);
                valuesForCurrentColumn.add(val);
            }
            right--;

            int index = i;
            for (int x : valuesForCurrentColumn) {
                result[index][i] = x;
                index++;
            }
        }

        ArrayList<ArrayList<Integer>> resultConverted = new ArrayList<>();
        for (int[] x : result) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int y : x) {
                row.add(y);
            }
            resultConverted.add(row);
        }

        return resultConverted;
    }
}
