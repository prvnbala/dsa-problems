// You are given a n x n 2D matrix A representing an image.
// Rotate the image by 90 degrees (clockwise).
// You need to do this in place.
// Note: If you end up using an additional array, you will only receive partial score.

// 1 <= n <= 1000

import java.util.ArrayList;
import java.util.Collections;

public class RotateMatrix {
    public void solve(ArrayList<ArrayList<Integer>> A) {
        transposeMatrix(A);
        reverseEachRowOfMatrix(A);
    }

    private void transposeMatrix(ArrayList<ArrayList<Integer>> A) {
        //convert each row into a column in place.
        int size = A.size();
        for (int i = 0; i < size; i++) {
            swapRowToCol(A, i);
        }
    }

    private void swapRowToCol(ArrayList<ArrayList<Integer>> A, int rowIndex) {
        for (int columnIndex = rowIndex; columnIndex < A.size(); columnIndex++) {
            int valueInCurrentRow = A.get(rowIndex).get(columnIndex);
            int valueInRowColumnSwapped = A.get(columnIndex).get(rowIndex);

            //swapping values
            A.get(rowIndex).set(columnIndex, valueInRowColumnSwapped);
            A.get(columnIndex).set(rowIndex, valueInCurrentRow);
        }
    }

    private void reverseEachRowOfMatrix(ArrayList<ArrayList<Integer>> A) {
        for (int i = 0; i < A.size(); i++) {
            reverseArrayList(A.get(i));
        }
    }

    private void reverseArrayList(ArrayList<Integer> A) {
        int leftPointer = 0, rightPointer = A.size() - 1;
        while (leftPointer < rightPointer) {
            Collections.swap(A, leftPointer, rightPointer);
            leftPointer++;
            rightPointer--;
        }
    }
}
