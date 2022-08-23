// Print a Pattern According to The Given Value of A.
// Example: For A = 3 pattern looks like:

//     1
//   2 1
// 3 2 1

import java.util.ArrayList;
import java.util.Collections;

public class PatternPrinting2 {
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> masterCopy = new ArrayList<>(Collections.nCopies(A, 0));

        for (int i = 0; i < A; i++) {
            masterCopy.set(i, i + 1);
            ArrayList<Integer> duplicateCopy = new ArrayList<>(masterCopy);
            reverseArray(duplicateCopy);
            result.add(duplicateCopy);
        }
        return result;
    }

    private void reverseArray(ArrayList<Integer> array) {
        int l = 0, r = array.size() - 1;
        while (l < r) {
            Collections.swap(array, l, r);
            l++;
            r--;
        }
    }
}
