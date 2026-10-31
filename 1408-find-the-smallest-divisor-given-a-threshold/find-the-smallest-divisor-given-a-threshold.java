class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        // imt maxElement = nums[0];
        // for(int i = 1; i<nums.length; i++){
        //     if(nums[i] > maxElement){
        //         maxElement = nums[i];
        //     }
        // }
        // int result = 0;
        // int divisionsResult = 0;
        // for(int i = 1; i<= maxElement; i++){
        //     result = 0;
        //     for(int j = 0; j < nums.length; j++){
        //         divisionsResult = (int)Math.ceil((double)nums[j] / i); 
        //         result = result + divisionsResult;
        //     }
        //     if(result <= threshold){
        //         return i;
        //     }
        // }
        
        // OPTIMAL APPROACH

        int maxElement = nums[0];
        for(int i = 1; i<nums.length; i++){
            if(nums[i] > maxElement){
                maxElement = nums[i];
            }
        }
        int left = 1;
        int right = maxElement;
        int ans = 0;
        while(left <= right){
            int mid = left + (right - left)/2;
            int result = func(mid, nums);
            if(result <= threshold){
                 ans = mid;
                 right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return ans;
    }
    public static int func(int mid, int[] nums){
        int divisionsResult = 0;
        int result = 0;
         for(int j = 0; j < nums.length; j++){
                divisionsResult = (int)Math.ceil((double)nums[j] / mid); 
                result = result + divisionsResult;
            }
            return result;
    }
}