// Given an integer A, return the number of trailing zeroes in A! i.e., factorial of A.
// Note: Your solution should run in logarithmic time complexity.

// 1 <= A <= 10^9

class TrailingZerosInFactorial {
    public int trailingZeroes(int A) {
        int result = 0;
        while (A > 0) {
            result += A / 5;
            A /= 5;
        }
        return result;
    }
}
