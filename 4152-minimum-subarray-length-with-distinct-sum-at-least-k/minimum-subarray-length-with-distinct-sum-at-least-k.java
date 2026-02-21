class Solution {
    public int minLength(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        int l = 0, sum = 0, minlen = Integer.MAX_VALUE;
        
        for (int r = 0; r < nums.length; r++) {
            // Add current element to frequency map
            int countR = counts.getOrDefault(nums[r], 0);
            if (countR == 0) {
                sum += nums[r]; // Only add to sum if it's the first occurrence
            }
            counts.put(nums[r], countR + 1);

            // While the sum of distinct elements meets the target
            while (sum >= k) {
                minlen = Math.min(minlen, r - l + 1);
                
                // Remove the leftmost element
                int countL = counts.get(nums[l]);
                if (countL == 1) {
                    sum -= nums[l]; // Only subtract if it's the last occurrence
                }
                
                if (countL > 1) {
                    counts.put(nums[l], countL - 1);
                } else {
                    counts.remove(nums[l]);
                }
                l++;
            }
        }
        
        return (minlen == Integer.MAX_VALUE) ? -1 : minlen;
   
    }
}