class Solution {
    public long countOperationsToEmptyArray(int[] nums) {
        int n = nums.length;
        long[] keys = new long[n];
        for (int i = 0; i < n; i++) keys[i] = (((long) nums[i]) << 32) | (i & 0xffffffffL);
        java.util.Arrays.sort(keys);
        long ans = n;
        int prev = (int) keys[0];
        for (int k = 1; k < n; k++) {
            int idx = (int) keys[k];
            if (idx < prev) ans += n - k;
            prev = idx;
        }
        return ans;  
    
    }
}