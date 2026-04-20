class Solution {
        public int allWays(int idx,int sum,int[] nums,int target,int n,int[][] dp,int offset){

        if(idx == n){
            if(sum == target){
                return 1;
            }
            return 0;
        }

        if(dp[idx][sum + offset] != -1){
            return dp[idx][sum+offset];
        }
        
        int add = allWays(idx + 1,sum + nums[idx],nums,target,n,dp,offset);
        int subs = allWays(idx + 1,sum - nums[idx],nums,target,n,dp,offset);
        dp[idx][sum+offset] = add + subs;
        return add + subs;
    }
    public int findTargetSumWays(int[] nums, int target) {
        
        int n = nums.length;
        int max = 0;
        for(int i = 0 ; i < n;i++){
            max += nums[i];
        }
        int[][] dp = new int[n][2*max + 1];
        for(int i = 0;i < n;i++){
            Arrays.fill(dp[i],-1);
        }
        return allWays(0,0,nums,target,n,dp,max);
    }
}