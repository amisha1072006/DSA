class Solution {
    public int arrangeCoins(int n) {
            double n1= (Math.sqrt(8.0* n+1)-1)/2;
        int result;
        if( n1 %1 !=0)
        {
            result = (int)Math.floor(n1);
        }
        else{
            result = (int)n1;
        }
        return result;
    
    }
}