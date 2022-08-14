// Write a function that takes an integer and returns the number of 1 bits it has.
// 1 <= A <= 1e9

class Solution {
    public int numSetBits(int A) {
        int counter = 0;
        for (int i = 0; i < 32; i++) {
            if ((A & (1 << i)) > 0) counter++;
        }
        return counter;
    }
}
