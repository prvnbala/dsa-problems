// Given three integers A, B, and C, where A represents n, B represents r, 
// and C represents p and p is a prime number greater than equal to n, 
// find and return the value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.
// x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
// NOTE: For this problem, we are considering 1 as a prime.

// 1 <= A <= 106
// 1 <= B <= A
// A <= C <= 10^9+7

class ComputeNCRModP {
    public int solve(int A, int B, int C) {
        int denominatorFactorialToConsider = Math.min(B, A - B);
        int denominatorFactorialToCancel = Math.max(B, A - B); //cancel the biggest value with numerator

        long numeratorFactorial = 1L;
        for (long i = A; i > denominatorFactorialToCancel; i--) {
            numeratorFactorial = (numeratorFactorial * i) % C;

        }

        long denominatorFactorial = 1L;
        for (int i = 1; i <= denominatorFactorialToConsider; i++) {
            denominatorFactorial = (denominatorFactorial * i) % C;
        }

        //modulo inverse denominator to multiply with numerator 
        long denominatorFactorialInverse = primeModuloInverse(denominatorFactorial, C);
        long result = (numeratorFactorial * denominatorFactorialInverse) % C;
        return (int) result;
    }

    private int primeModuloInverse(long number, long mod) {
        return binaryExponentiation(number, mod - 2, mod);
    }

    private int binaryExponentiation(long base, long power, long mod) {
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

    private boolean isOdd(long number) {
        return (number % 2) != 0;
    }
}
