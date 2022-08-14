// Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).

// "^" means power,

// "%" means "mod", and

// "!" means factorial.

// 1 <= A, B <= 5e5

class Solution {

    private int mod = 1000 * 1000 * 1000 + 7;

    public int solve(int A, int B) {
        int power = factorial(B);
        return binaryExponent(A, power);
    }

    private int factorial(int B) {
        long ans = 1;
        for(int i = 2; i <= B; i++) {
            ans = (ans * i) % (mod -1);
        }
        return (int) ans;
    }

    private int binaryExponent(long base, long power) {
        if(power == 0) {
            return 1;
        }

        if(power == 1) {
            return (int) base;
        }

        long ans = 1;
        while(power > 0) {
            if(power % 2 == 1) {
                ans = (ans * base) % mod;
            }

            base = (base * base) % mod;
            power /= 2;
        }
        return (int) ans;
    }
}
