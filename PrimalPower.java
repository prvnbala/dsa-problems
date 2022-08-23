// "Primal Power" of an array is defined as the count of prime numbers present in it.
// Given an array of integers A of length N, you have to calculate its Primal Power.

// 1 <= N <= 10^3
// -10^6 <= A[i] <= 10^6

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PrimalPower {
    public int solve(ArrayList<Integer> A) {
        Set<Integer> visitedPrimeNumbers = new HashSet<>();
        int primeCount = 0;
        for (int x : A) {
            if (isPrime(x, visitedPrimeNumbers)) {
                primeCount++;
            }
        }
        return primeCount++;
    }

    private boolean isPrime(int x, Set<Integer> visitedPrimeNumbers) {
        if (x < 2) {
            return false;
        }

        if (visitedPrimeNumbers.contains(x)) {
            return true;
        }

        for (int i = 2; i < x; i++) {
            if (isMultiple(x, i)) {
                return false;
            }
        }
        visitedPrimeNumbers.add(x);
        return true;
    }

    private boolean isMultiple(int number, int divisor) {
        return (number % divisor) == 0;
    }
}
