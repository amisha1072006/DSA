class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
       int lo = 0, hi = nums.length - 1;
       while(lo <= hi){
        int mid = lo + (hi-lo)/2;
        if(nums[mid] == target){
            return true;
        }
        else if(nums[lo] == nums[mid] && nums[mid] == nums[hi]){
            lo++;
            hi--;
            continue;
        }
        // left half is sorted
        else if(nums[lo] <= nums[mid]){
            //target lies in left half
            if(nums[lo] <= target && target <= nums[mid]){
                hi = mid-1;
            }
            // target lies in right half
            else{
                lo = mid+1;
            }
        }
        // right half is sorted
        else{
            // target lies in right half 
            if(nums[mid] <= target && target <= nums[hi]){
                lo = mid +1;
            }
            // target lies in left half
            else{
                hi = mid -1;
            }
        }
       }
       return false;
    }
}
