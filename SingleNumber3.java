// Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
// Find the two integers that appear only once.

// Note: Return the two numbers in ascending order.

// 2 <= |A| <= 100000
// 1 <= A[i] <= 10^9


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class SingleNumber3 {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        int xorValue = getXorOfAllElementsInArray(A); //cancels duplicates and have xor of two single numbers
        int position = findLeftMostSetBitPosition(xorValue); //find first bit difference in the two single numbers

        int singleNumberWithSetBitAtPosition = 0;
        int singleNumberWithUnsetBitAtPosition = 0;

        for (int x : A) {
            if (isBitSetAtPosition(x, position)) {
                singleNumberWithSetBitAtPosition ^= x;
            } else {
                singleNumberWithUnsetBitAtPosition ^= x;
            }
        }

        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(
                singleNumberWithSetBitAtPosition,
                singleNumberWithUnsetBitAtPosition));

        Collections.sort(result);
        return result;
    }

    private int getXorOfAllElementsInArray(ArrayList<Integer> A) {
        int xorValue = 0;
        for (int x : A) {
            xorValue ^= x;
        }
        return xorValue;
    }

    private int findLeftMostSetBitPosition(int value) {
        for (int i = 0; i < 32; i++) {
            if (isBitSetAtPosition(value, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isBitSetAtPosition(int value, int position) {
        return (value & (1 << position)) > 0;
    }
}
