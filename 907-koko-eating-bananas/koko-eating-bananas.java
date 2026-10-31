class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxElement = piles[0];
        for(int i = 1; i<piles.length; i++){
            if(piles[i] > maxElement){
                maxElement = piles[i];
            }
        }
        int left = 1;
        int right = maxElement;
        int ans = 0;
        while(left <= right){
            int mid = left + (right - left)/2;
            long result = func(mid, piles);
            if(result <= h){
                ans = mid;
                 right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return ans;
    }
    public static long func(int mid, int[] nums){
        int divisionsResult = 0;
        long result = 0;
         for(int j = 0; j < nums.length; j++){
                divisionsResult = (int)Math.ceil((double)nums[j] / mid); 
                result = result + divisionsResult;
            }
            return result;
    }
}