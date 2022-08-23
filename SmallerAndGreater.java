// You are given an Array A of size N.

// Find for how many elements, there is a strictly smaller element and a strictly greater element.

import java.util.ArrayList;
import java.util.Collections;

class SmallerAndGreater {
    public int solve(ArrayList<Integer> A) {

        int counter = 0;
        int max = Collections.max(A);
        int min = Collections.min(A);

        for (Integer x : A) {
            if (x > min && x < max) {
                counter++;
            }
        }
        return counter;
    }
}
