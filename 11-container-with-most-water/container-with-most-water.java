class Solution {
    public int maxArea(int[] height) {
               int l = 0, r = height.length - 1;
        int ans = 0;

        while (l < r) {
            // Calculate the area between l and r
            int water = Math.min(height[l], height[r]) * (r - l);
            // Update the maximum area
            ans = Math.max(ans, water);

            // Move the pointer pointing to the smaller line
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return ans; 
    }
}