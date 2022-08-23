// Given two integers A and B, find the greatest possible positive integer M, such that A % M = B % M.
// 1 <= A, B <= 10^9
// A != B

class ABAndModulo {
    public int solve(int A, int B) {
        return Math.abs(A - B);
    }
}
