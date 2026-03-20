class Solution {
    public long maxProduct(int[] nums) {
        long ans = 100000;
        int max1 = 0, max2 = 0;

        for (int num : nums) {
            num = Math.abs(num);
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        if (max1 == 0 || max2 == 0) return 0;

        return ans * max1 * max2;
    }
}