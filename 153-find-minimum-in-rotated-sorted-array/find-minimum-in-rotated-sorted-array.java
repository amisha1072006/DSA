class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int lo = 0;
        int hi = n-1;
        int ans = Integer.MAX_VALUE;
        while(lo <= hi){
            int mid = (lo + hi)/2;
            // if(nums[lo] <= nums[hi]){
            //     ans = Math.min(ans, nums[lo]);
            //     break;
            // }
            if(nums[lo] <= nums[mid]){
                ans = Math.min(ans, nums[lo]);
                lo = mid+1;
            }
            else{
                hi = mid-1;
                ans = Math.min(ans, nums[mid]);
            }
        }
        return ans;
    }
}