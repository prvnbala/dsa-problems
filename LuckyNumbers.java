// A lucky number is a number that has exactly 2 distinct prime divisors.
// You are given a number A, and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).

// 1 <= A <= 50000

class Solution {
    public int solve(int A) {
        int[] primeDivisorCount = new int[A + 1];
        for(int i = 2; i <= A; i++) {
            if(primeDivisorCount[i] == 0) { //meaning current number is prime
                for(int j = 2 * i; j <= A; j += i) {
                    primeDivisorCount[j]++;
                }
            }
        }

        int result = 0;
        for(int x : primeDivisorCount) {
            if(x == 2) {
                result++;
            }
        }

        return result;
    }
}
