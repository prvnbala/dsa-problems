// Given three integers A, B, and C, where A represents n, B represents r, and C represents m, 
// find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.
// x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

// 1 <= A * B <= 10^6
// 1 <= B <= A
// 1 <= C <= 10^6

class Solution {
    public int solve(int A, int B, int C) {
        int[][] dp = new int[A + 1][B + 1];
        for(int i = 1; i < A + 1; i++) {
            for(int j = 1; j < B + 1; j++) {
                if(i == j) {
                    dp[i][j] = 1;
                } else if(i < j) {
                    dp[i][j] = 0;
                    break;
                } else if(j == 1) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % C;
                }
            }
        }
        return dp[A][B] % C;
    }
}
