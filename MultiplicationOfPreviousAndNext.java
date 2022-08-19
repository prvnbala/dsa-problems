// Given an array of integers A, update every element with multiplication of 
// previous and next elements with following exceptions. 
// a) First element is replaced by multiplication of first and second. 
// b) Last element is replaced by multiplication of last and second last.

// 1 <= length of the array <= 100000
// -10^4 <= A[i] <= 10^4 

class MultiplicationOfPreviousAndNext {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int size = A.size();
        int lastIndex = size - 1;
        int previousElement = A.get(0); 
        for(int i = 0; i < A.size(); i++) {
            int nextElement = (i == lastIndex) ? A.get(i) : A.get(i + 1);
            int product = previousElement * nextElement;
            previousElement = A.get(i);
            A.set(i, product);
        }
        return A;
    }
}
