class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;

        int n = nums.length;
        Boolean[][] dp = new Boolean[n][sum / 2 + 1];

        return part(nums, sum / 2, n - 1, dp);
    }

    public boolean part(int[] nums, int sum, int n, Boolean[][] dp) {
        if (sum == 0) return true;
        if (n < 0) return false;

        if (dp[n][sum] != null) return dp[n][sum];

        if (nums[n] > sum)
            return dp[n][sum] = part(nums, sum, n - 1, dp);

        boolean take = part(nums, sum - nums[n], n - 1, dp);
        boolean nottake = part(nums, sum, n - 1, dp);

        return dp[n][sum] = take || nottake;
    }
}