class Solution {
    public int search(int[] nums, int target) {
       int n = nums.length;
       int lo = 0, hi = nums.length - 1;
       while(lo <= hi){
        int mid = lo + (hi-lo)/2;
        if(nums[mid] == target){
            return mid;
        }
        // left half is sorted
        else if (nums[lo] <= nums[mid]){
            //target lies in the left half
            if(nums[lo] <= target && nums[mid] >= target){
                hi = mid-1;
            }
            else // target lies in the right half
            {
                lo = mid + 1;
            }
        }
        else // right half is sorted
        {
            // target is in the right half
            if(nums[mid] <= target && target <= nums[hi]){
                lo = mid +1;
            }
            else // target is in the left half
            {
                hi = mid - 1;
            }
        }
       } 
       return -1;
    }
}