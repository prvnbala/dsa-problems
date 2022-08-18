// Given a positive integer A, 
// return an array of strings with all the integers from 1 to N. 
// But for multiples of 3 the array should have "Fizz" instead of the number. 
// For the multiples of 5, the array should have "Buzz" instead of the number. 
// For numbers which are multiple of 3 and 5 both, the array should have "FizzBuzz" instead of the number.

// Look at the example for more details.

// 1 <= A <= 500000

class FizzBuzz {
    public ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> result = new ArrayList<>();
        for(int i = 1; i <= A; i++) {
            String value;
            if(isMultiple(i, 15)) {
                value = "FizzBuzz";
            } else if (isMultiple(i, 3)) {
                value = "Fizz";
            } else if (isMultiple(i, 5)) {
                value = "Buzz";
            } else {
                value = String.valueOf(i);
            }
            result.add(value);
        }
        return result;
    }

    private boolean isMultiple(int number, int divisor) {
        return (number % divisor) == 0;
    }
}
