class Solution {
    public double helper(int[] nums, int k, int[] prefix, int index, double[][] dp) {
        if(index < 0)   return k == 0 ? 0 : Integer.MIN_VALUE;
        if(k <= 0)   return Integer.MIN_VALUE;
        if(dp[index][k] != -1)  return dp[index][k];
        dp[index][k] = 0.0;
        for(int i = index; i >= 0; i--) {
            dp[index][k] = Math.max(dp[index][k], (((double) (prefix[index + 1] - prefix[i]))/(index - i + 1)) + helper(nums, k - 1, prefix, i - 1, dp));
        }
        return dp[index][k];
    }
    public double largestSumOfAverages(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];
        for(int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        double[][] dp = new double[nums.length][k + 1];
        for(int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], -1);
        return helper(nums, k, prefix, nums.length - 1, dp);
    
    }
}