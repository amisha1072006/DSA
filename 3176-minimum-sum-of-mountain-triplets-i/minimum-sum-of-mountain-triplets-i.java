class Solution {
    public int minimumSum(int[] nums) {
       int min_sum = Integer.MAX_VALUE;
        int n = nums.length;
        for(int j = 0; j < n; j++)
        {
            for(int e = j + 1; e < n; e++)
            {
                for(int s = e + 1; s < n; s++)
                {
                    if(nums[j] < nums[e] && nums[s] < nums[e] && nums[j] + nums[e] + nums[s] < min_sum)
                        min_sum = nums[j] + nums[e] + nums[s];
                }
            }
        }
        return min_sum == Integer.MAX_VALUE ? -1 : min_sum;
    
    }
}