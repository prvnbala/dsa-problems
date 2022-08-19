// Given an array of integers A and multiple values in B, 
// which represents the number of times array A needs to be left rotated.

// Find the rotated array for each value and return the result in the from of a matrix 
// where ith row represents the rotated array for the ith value in B.

// 1 <= length of both arrays <= 2000 
// -10^9 <= A[i] <= 10^9 0 <= B[i] <= 2000

class MultipleLeftRotationsOfTheArray {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int rotationCount : B) {
            ArrayList<Integer> currentRow = new ArrayList<>(A);
            leftRotateArrayNTimes(currentRow, rotationCount);
            result.add(currentRow);
        }
        return result;
    }

    private ArrayList<Integer> leftRotateArrayNTimes(ArrayList<Integer> array, int N) {
        int size = array.size();
        N = N > size ? N % size : N;                          //if N is greater than size, mod with size
        int lastIndex = size - 1;
        reverseSubArray(array, 0, lastIndex);                 //reverse all the elements 
        reverseSubArray(array, 0, lastIndex - N);             //reverse except last N elements
        reverseSubArray(array, lastIndex - N + 1, lastIndex); //reverse last N elements 
        return array;
    }

    private ArrayList<Integer> reverseSubArray(ArrayList<Integer> array, int fromIndex, int toIndex) {
        while(fromIndex < toIndex) {
            Collections.swap(array, fromIndex++, toIndex--);
        }
        return array;
    }
}
