// Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.
// NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
// 2 <= |A| <= 2000000
// 0 <= A[i] <= INTMAX

class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        int ans = 0; 
        for(Integer x: A) {
            ans = ans^x;
        }
        return ans; 
    }
}
