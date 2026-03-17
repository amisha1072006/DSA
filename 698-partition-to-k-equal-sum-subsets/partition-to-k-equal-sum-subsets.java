class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
                int sum = 0;

        for(int i : nums) sum += i;
        
        if(sum % k != 0) return false;

        boolean visited[] = new boolean[nums.length];

        return backtrack(nums, visited, k, 0, 0, sum / k);
    }
    boolean backtrack(int nums[], boolean visited[], int k, int index, int sum, int target)
    {
        if(k == 1) 
        {
            return true;
        }

        if(sum == target) 
        {
            return backtrack(nums, visited, k - 1, 0, 0, target);
        }

        for(int i=index;i<nums.length;i++)
        {
            if(visited[i] || sum + nums[i] > target) continue;

            visited[i] = true;

            if(backtrack(nums, visited, k, i + 1, sum + nums[i], target)) return true;

            visited[i] = false;
        }
        return false;
    }
}