// Given an integer A, find and return the Ath magic number.
// A magic number is defined as a number that can be expressed 
// as a power of 5 or a sum of unique powers of 5.
// First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….

// 1 <= A <= 5000

class FindNthMagicNumber {
    public int solve(int A) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (isSetBitAtPosition(A, i)) {
                ans += Math.pow(5, i + 1);
            }
        }
        return ans;
    }

    private boolean isSetBitAtPosition(int number, int position) {
        return (number & (1 << position)) > 0;
    }
}
