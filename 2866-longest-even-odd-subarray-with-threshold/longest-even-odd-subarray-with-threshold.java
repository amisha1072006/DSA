class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
       int l = 0, maxLen = 0;

        for(int r = 0; r<nums.length; r++) {
            // if curr is > threashold
            if(nums[r] > threshold) {
                l = r + 1;
                continue;
            }

            // odd - even alterate
            if(r > l && nums[r] % 2 == nums[r - 1] % 2) {
                l = r;
            }

            // if starting is odd
            if(nums[l] % 2 != 0) l++;

            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    
    }
}