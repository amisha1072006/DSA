class Solution {
    public int mySqrt(int x) {
        // BRUTE FORCE APPROACH
        // TC = O(n), SC = O(1)

         long ans = 1;
        for(long i = 0; i<=x; i++){
            if(i * i <= x){
               ans = i;
            }else{
                break;
            }
        }
        return (int)ans;
    }
}