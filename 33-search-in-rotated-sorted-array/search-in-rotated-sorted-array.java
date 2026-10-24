class Solution {
    public int search(int[] nums, int target) {

      // TC = 0(logn), SC = 0(1)
       int n = nums.length;
       int lo = 0, hi = nums.length - 1;
       while(lo <= hi){
        int mid = lo + (hi-lo)/2;
        if(nums[mid] == target){
            return mid;
        }
        // left half is sorted
        else if(nums[lo] <= nums[mid]){
            if(nums[lo] <= target && target <= nums[mid]){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        else{
            if(nums[mid] <= target && target <= nums[hi]){
                lo = mid +1;
            }
            else{
                hi = mid -1;
            }
        }
       }
       return -1;
    }
}