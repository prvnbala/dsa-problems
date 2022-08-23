// Given an array of integers, every element appears thrice except for one, which occurs once.
// Find that element that does not appear thrice.
// NOTE: Your algorithm should have a linear runtime complexity.
// Could you implement it without using extra memory?

// 2 <= A <= 5*10^6
// 0 <= A <= INTMAX

import java.util.List;

class SingleNumber2 {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = countSetBitAtPosition(A, i);
            if (!isDivisible(count, 3)) {
                result = setBitAtPosition(result, i);
            }
        }
        return result;
    }

    private int countSetBitAtPosition(List<Integer> A, int position) {
        int count = 0;
        for (int x : A) {
            if (isSetBitAtPosition(x, position)) {
                count++;
            }
        }
        return count;
    }

    private boolean isSetBitAtPosition(int number, int position) {
        return (number & (1 << position)) > 0;
    }

    boolean isDivisible(int numerator, int divider) {
        return numerator % divider == 0;
    }

    int setBitAtPosition(int number, int position) {
        return (number | (1 << position));
    }
}
