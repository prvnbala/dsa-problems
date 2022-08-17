// Given three integers A, B, and C, where A represents n, B represents r, and C represents m, 
// find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.
// x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

// 1 <= A * B <= 10^6
// 1 <= B <= A
// 1 <= C <= 10^6

class Solution {
    public int solve(int A, int B, int C) {
        
        int[] prev = new int[B + 1];
        int[] curr = new int[B + 1];

        for(int i = 1; i < A+1; i++) {
            for(int j = 1; j < B+1; j++) {
                if(i == j) {
                    curr[j] = 1;
                } else if(i < j) {
                    curr[j] = 0;
                } else if(j == 1) {
                    curr[j] = i;
                } else {
                    curr[j] = (prev[j-1] + prev[j]) % C;
                }
            }
            copyArray(curr, prev);
        }
        return curr[B] % C;
    }

    private void copyArray(int[] fromArray, int[] toArray) {
        for(int i = 0; i < fromArray.length; i++) {
            toArray[i] = fromArray[i];
        }
    }
}
