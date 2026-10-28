class Solution {
    public int mySqrt(int x) {
        // BRUTE FORCE APPROACH
        // TC = O(n), SC = O(1)

        // long ans = 1;
        // for(long i = 0; i<=x; i++){
        //     if(i * i <= x){
        //        ans = i;
        //     }else{
        //         break;
        //     }
        // }
        // return (int)ans;

        // OPTIMIZED APPROACH
        // TC = O(logn), SC = O(1)

        long ans = 0;
        long left = 0;
        long right = x;
        while(left <= right){
            long mid = (left + right)/2;
            long midSqr= mid * mid;
            if(midSqr <= x){
                ans = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return (int)ans;
    }
}