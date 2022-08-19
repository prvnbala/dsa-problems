// Given an array A and an integer B. 
// A pair(i, j) in the array is a good pair if i != j and (A[i] + A[j] == B). 
// Check if any good pair exist or not.


// 1 <= A.size() <= 10^4
// 1 <= A[i] <= 10^9
// 1 <= B <= 10^9


class GoodPair {
    public int solve(ArrayList<Integer> A, int B) {
        Set<Integer> visitedElements = new HashSet<>();
        for(int currentValue : A) {
            int expectedPairValue = B - currentValue;
            if(visitedElements.contains(expectedPairValue)) {
                return 1;
            } else {
                visitedElements.add(currentValue);
            }
        }
        return 0;
    }
}
