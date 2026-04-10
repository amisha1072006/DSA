class Solution {
            public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        return helper(arr, 0, n - 1, new int[n][n]);
    }

    public int helper(int[] arr, int left, int right, int[][] dp) {
        if (left == right) return 0;
        if (dp[left][right] != 0) return dp[left][right];
        int min = Integer.MAX_VALUE;

        for (int i = left; i < right; i++) {
            int leftMax = findMax(arr, left, i);
            int rightMax = findMax(arr, i + 1, right);
            int value = leftMax * rightMax + helper(arr, left, i, dp) + helper(arr, i + 1, right, dp);
            min = Math.min(min, value);
        }
        dp[left][right] = min;
        return min;
    }

    private int findMax(int[] arr, int left, int right) {
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}