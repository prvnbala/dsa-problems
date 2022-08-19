// Given two binary strings, return their sum (also a binary string).
// a = "100"
// b = "11"
// Return a + b = "111".


class AddBinaryStrings {
    public String addBinary(String A, String B) {
        int i = A.length() - 1;
        int j = B.length() - 1;
        int x, y, carry = 0;

        StringBuilder ans = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {

            x = i >= 0 ? Character.getNumericValue(A.charAt(i--)) : 0;
            y = j >= 0 ? Character.getNumericValue(B.charAt(j--)) : 0;

            int sum = carry + x + y;

            switch (sum) {
                case 0:
                    carry = 0;
                    ans.append('0');
                    break;
                case 1:
                    carry = 0;
                    ans.append('1');
                    break;
                case 2:
                    carry = 1;
                    ans.append('0');
                    break;
                case 3:
                    carry = 1;
                    ans.append('1');
                    break;
            }
        }
        return ans.reverse().toString();
    }
}
