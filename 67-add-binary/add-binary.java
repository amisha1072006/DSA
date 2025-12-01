import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
                BigInteger num1 = new BigInteger(a, 2); // Convert a to integer
        BigInteger num2 = new BigInteger(b, 2); // Convert b to integer
        BigInteger sum = num1.add(num2); // sum = num1 + num2
        return sum.toString(2); // return sum as binary string

    }
}