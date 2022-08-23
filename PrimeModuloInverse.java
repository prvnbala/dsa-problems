// Given two integers A and B. Find the value of A^(-1) mod B where B is a prime number and gcd(A, B) = 1.
// A^(-1) mod B is also known as modular multiplicative inverse of A under modulo B.

// 1 <= A <= 10^9
// 1<= B <= 10^9
// B is a prime number

class PrimeModuloInverse {
    public int solve(int A, int B) {
        return binaryExponent(A, B - 2, B);
    }

    private int binaryExponent(long base, long power, long mod) {
        long ans = 1;
        while (power > 0) {
            if (isOdd(power)) {
                ans = (ans * base) % mod;
            }
            base = (base * base) % mod;
            power /= 2;
        }
        return (int) ans;
    }

    private boolean isOdd(long num) {
        return num % 2 != 0;
    }
}
