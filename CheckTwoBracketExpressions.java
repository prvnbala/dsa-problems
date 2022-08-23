// Given two strings A and B. Each string represents an expression 
// consisting of lowercase English alphabets, '+', '-', '(' and ')'.
// The task is to compare them and check if they are similar.
//  If they are identical, return 1 else, return 0.

// NOTE: It may be assumed that there are at most 26 operands 
// from 'a' to 'z', and every operand appears only once.

// 1 <= length of the each String <= 100

import java.util.Arrays;
import java.util.Stack;

class CheckTwoBracketExpressions {
    public int solve(String A, String B) {
        boolean[] signInfoForEachCharInA = getSignInfoForCharsInExpression(A);
        boolean[] signInfoForEachCharInB = getSignInfoForCharsInExpression(B);
        boolean isSameExpression = Arrays.equals(signInfoForEachCharInA, signInfoForEachCharInB);
        return isSameExpression ? 1 : 0;
    }

    private boolean[] getSignInfoForCharsInExpression(String input) {
        boolean[] signInfo = new boolean[26]; //for mapping 26 lowercase chars
        Stack<Boolean> globalSign = new Stack<>();
        globalSign.push(true);

        for (int i = 0; i < input.length(); i++) {
            char x = input.charAt(i);

            if (isOpeningParanthesis(x)) {
                if (isAdjacentSignNegative(input, i)) {
                    updateGlobalSign(globalSign, true);
                } else {
                    updateGlobalSign(globalSign, false);
                }

            } else if (isClosingParanthesis(x)) {
                revertGlobalSignToPreviousSign(globalSign);

            } else if (isOperand(x)) {
                boolean localSignForX = getLocalSign(input, i);
                boolean globalSignForX = globalSign.peek();
                boolean finalSign = (localSignForX == globalSignForX);
                signInfo[x - 'a'] = finalSign;
            }
        }
        return signInfo;
    }

    private boolean isAdjacentSignNegative(String input, int index) {
        int adjacentIndex = index - 1;
        if (adjacentIndex < 0) return false;
        if (isMinus(input.charAt(adjacentIndex))) return true;
        return false;
    }

    private boolean isOpeningParanthesis(char x) {
        return x == '(';
    }

    private boolean isClosingParanthesis(char x) {
        return x == ')';
    }

    private boolean isMinus(char x) {
        return x == '-';
    }

    private void updateGlobalSign(Stack<Boolean> stack, boolean reverseSign) {
        boolean currentGlobalSign = stack.peek();
        boolean newGlobalSign = currentGlobalSign;
        if (reverseSign) {
            newGlobalSign = !currentGlobalSign;
        }
        stack.push(newGlobalSign);
    }

    private void revertGlobalSignToPreviousSign(Stack<Boolean> stack) {
        stack.pop();
    }

    private boolean getLocalSign(String input, int index) {
        return (!isAdjacentSignNegative(input, index));
    }

    private boolean isOperand(char x) {
        return (x >= 'a' && x <= 'z');
    }
}
