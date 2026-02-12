class Solution {
    public int primePalindrome(int n) {
                if (n==2 || n==3 || n==5 || n==7 || n==11  ){ return n;}
        if(n>=31880255){ return 100030001; }
        int s=n+1;
        while (true) {
            if (palin(s) && isPrime(s)) {
                return s; 
            }
            s++;
            if (s > 2 && s % 2 == 0) {
                s++;
            }
        }
    }
    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; 
            }
        }
        return true;
    }
    private boolean palin(int number) {
         int reversed = 0;
         int original = number;
        while (number != 0) {
            int digit = number % 10; 
            reversed = reversed * 10 + digit; 
            number /= 10; 
        }return original == reversed;

    }
}