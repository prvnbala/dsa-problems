// Given a non-negative number represented as an array of digits, 
// add 1 to the number ( increment the number represented by the digits ).

// The digits are stored such that the most significant digit is at the head of the list.

// NOTE: Certain things are intentionally left unclear in this question 
// which you should practice asking the interviewer. 

// For example: for this problem, the following are some good questions to ask :
// Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
// A: For the purpose of this question, YES
// Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
// A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.

// 1 <= size of the array <= 1000000


class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        Stack<Integer> digits = getStackOfDigitsAfterIncrement(A);
        removeLeadingZerosIfPresent(digits);
        return getListFromStackTopDown(digits);
    }

    private Stack<Integer> getStackOfDigitsAfterIncrement(ArrayList<Integer> A) {
        Stack<Integer> digitSums = new Stack<>();
        int lastIndex = A.size() - 1;
        int carry = 1;
        for(int i = lastIndex; i >= 0; i--) {
            int currentDigit = A.get(i);
            int digitSum = currentDigit + carry;
            carry = digitSum / 10;
            digitSum = digitSum % 10;
            digitSums.push(digitSum);
        }
        if(carry > 0) {
            digitSums.push(carry);
        }
        return digitSums;
    }

    private Stack<Integer> removeLeadingZerosIfPresent(Stack<Integer> digits) {
        while(digits.peek() == 0) {
            digits.pop();
        }
        return digits;
    }

    private ArrayList<Integer> getListFromStackTopDown(Stack<Integer> stack) {
        ArrayList<Integer> result = new ArrayList<>();
        while(! stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }
}
