class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0)
            return 1;
        
        if(n == 1)
            return 10;
        
        int product =9;
        int result = 10;
        
        for(int i=2; i<=n; i++)
        {
            product = product * (11-i);
            result += product;
        }
        
        return result;

    }
}