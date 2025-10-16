class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, s = 0, m = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            s += nums[r];
            while (s >= target) {
                m = Math.min(m, r - l + 1);
                s -= nums[l++];
            }
        }
        return (m == Integer.MAX_VALUE) ? 0 : m;
   
    }
}