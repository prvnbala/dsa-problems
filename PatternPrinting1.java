// Print a Pattern According to The Given Value of A.

// Example: For A = 3 pattern looks like:
// 1 0 0
// 1 2 0
// 1 2 3

// 1 <= A <= 1000

class Solution {
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> master = new ArrayList<>(Collections.nCopies(A, 0));
        for(int i = 0; i < A; i++) {
            master.set(i, i + 1);
            result.add(new ArrayList<>(master));
        }
        return result;
    }
}
