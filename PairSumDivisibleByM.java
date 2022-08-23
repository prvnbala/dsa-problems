// Pair Sum divisible by M

// Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.

// Since the answer may be large, return the answer modulo (109 + 7).

// 1 <= length of the array <= 100000
// 1 <= A[i] <= 10^9
// 1 <= B <= 10^6

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class PairSumDivisibleByM {

    //solution idea: (a+b) % c = (a%c + b%c) % c;
    int mod = 1000 * 1000 * 1000 + 7;

    public int solve(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> modValueCounter = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            int x = A.get(i);
            int modValue = x % B;
            int currentCount = modValueCounter.containsKey(modValue) ? modValueCounter.get(modValue) : 0;
            modValueCounter.put(modValue, currentCount + 1);
            A.set(i, modValue);
        }

        long ans = 0;
        for (int x : A) {
            int xCompliment = (B - x) % B;
            if (modValueCounter.containsKey(x) && modValueCounter.containsKey(xCompliment)) {
                int xCount = modValueCounter.get(x);
                int xComplimentCount = modValueCounter.get(xCompliment);
                long totalPairs = 0;
                if (x == xCompliment) {
                    totalPairs = ((1L * xCount * (xCount - 1)) / 2) % mod;
                } else {
                    totalPairs = (1L * xCount * xComplimentCount) % mod;
                    modValueCounter.remove(xCompliment);
                }
                ans = (ans + totalPairs) % mod;
                modValueCounter.remove(x);
            }
        }
        return (int) ans;
    }
}
