// You are given an array of distinct integers A, you have to find and return all elements in array which have at-least two greater elements than themselves.

// NOTE: The result should have the order in which they are present in the original array.

// 3 <= |A| <= 10^5

// -10^9 <= A[i] <= 10^9

import java.util.ArrayList;

class ElementsWithTwoGreaterElements {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int x : A) {
            if (x > firstMax) {
                secondMax = firstMax;
                firstMax = x;
            } else if (x > secondMax) {
                secondMax = x;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int x : A) {
            if (x < secondMax) {
                result.add(x);
            }
        }

        return result;
    }
}
