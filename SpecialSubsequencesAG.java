// You have given a string A having Uppercase English letters.

// You have to find how many times subsequence "AG" is there in the given string.

// NOTE: Return the answer modulo 10^9 + 7 as the answer can be very large.

// 1 <= length(A) <= 10^5

public class SpecialSubsequencesAG {
    public int solve(String A) {
        int gCount = 0;
        int result = 0;
        int mod = 1000 * 1000 * 1000 + 7;

        for (int i = A.length() - 1; i >= 0; i--) {
            char x = A.charAt(i);

            if (x == 'G') {
                gCount++;
            } else if (x == 'A') {
                result = (result + gCount) % mod;
            }
        }

        return result;
    }
}
