// Given an integer array A of size N and an integer B, 
// you have to print the same array after rotating it B times towards the right.

// 1 <= N <= 10^6
// 1 <= A[i] <=10^8
// 1 <= B <= 10^9

import java.lang.*;
import java.util.*;

class RotationGame {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        
        Scanner consoleInput = new Scanner(System.in);
        RotationGame program = new RotationGame();
        int[] inputArray = program.getArrayFromConsoleInput(consoleInput);
        int rotationCount = consoleInput.nextInt();

        int[] rotatedArray = program.rightRotateArrayNTimes(inputArray, rotationCount);
        program.printArrayElements(rotatedArray);
    }

    private int[] getArrayFromConsoleInput(Scanner consoleInput) {
        int arraySize = consoleInput.nextInt();
        int[] result = new int[arraySize];
        for(int i = 0; i < arraySize; i++) {
            result[i] = consoleInput.nextInt();
        }
        return result;
    }

    private int[] rightRotateArrayNTimes(int[] array, int N) {
        int size = array.length;
        N = N > size ? N % size : N;          //if N is greater than size, mod with size
        int lastIndex = size - 1;
        reverseSubArray(array, 0, lastIndex); //reverse all the elements 
        reverseSubArray(array, 0, N - 1);     //reverse first N elements 
        reverseSubArray(array, N, lastIndex); //reverse remaining elements
        return array;
    }

    private int[] reverseSubArray(int[] array, int fromIndex, int toIndex) {
        while(fromIndex < toIndex) {
            int temp = array[fromIndex];
            array[fromIndex++] = array[toIndex];
            array[toIndex--] = temp;
        }
        return array;
    }

    private void printArrayElements(int[] array) {
        for(int x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
