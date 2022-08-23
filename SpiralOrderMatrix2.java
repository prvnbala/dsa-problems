// Given an integer A,
// generate a square matrix filled with elements from 1 to A^2
// in spiral order and return the generated square matrix.

// 1 <= A <= 1000
public class SpiralOrderMatrix2 {

    public int[][] generateMatrix(int A) {
        int[][] result = new int[A][A];

        int left = 0, right = A - 1, top = 0, bottom = A - 1;
        int num = 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result[top][i] = num++;
            }
            top++;

            if (top > bottom) break;

            for (int i = top; i <= bottom; i++) {
                result[i][right] = num++;
            }
            right--;

            if (right < left) break;

            for (int i = right; i >= left; i--) {
                result[bottom][i] = num++;
            }
            bottom--;

            if (bottom < top) break;

            for (int i = bottom; i >= top; i--) {
                result[i][left] = num++;
            }
            left++;
        }

        return result;
    }
}
