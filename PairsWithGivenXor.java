// Given an integer array A containing N distinct integers.
// Find the number of unique pairs of integers in the array whose XOR is equal to B.
// NOTE:
// Pair (a, b) and (b, a) is considered to be the same and should be counted once.

// 1 <= N <= 10^5
// 1 <= A[i], B <= 10^7

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PairsWithGivenXor {
    public int solve(ArrayList<Integer> A, int B) {
        Set<Integer> visitedElements = new HashSet<>();
        int count = 0;

        for(int current : A) {
            //proof:
            //a ^ b = target
            //a ^ a ^ b = a ^ target
            //b = a ^ target; since, a ^ a = 0; 0 ^ a = a;
            int match = B ^ current;

            if(visitedElements.contains(match)) {
                count++;
            }

            visitedElements.add(current);
        }

        return count;
    }
}
