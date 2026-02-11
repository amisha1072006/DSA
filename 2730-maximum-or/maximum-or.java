class Solution {
    public long maximumOr(int[] nums, int k) {
               int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] | nums[i];
        }
        
        suffix[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            suffix[i] = suffix[i+1] | nums[i];
        }
        
        long maxOr = 0;
        for (int i = 0; i < n; i++) {
            long or = ((long) nums[i]) * (1L << k) | (i > 0 ? prefix[i-1] : 0) | (i < n-1 ? suffix[i+1] : 0);
            maxOr = Math.max(maxOr, or);
        }
        
        return maxOr;
 
    }
}