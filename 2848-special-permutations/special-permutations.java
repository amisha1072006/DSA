class Solution {
        int MOD = (int)1e9+7;
            Integer[][][] dp ;
    public int specialPerm(int[] nums) {
       int n = nums.length;
        dp = new Integer[n][n][1<<n];
        return dfs(0,0,nums,0)%MOD;
    }
    public int dfs(int i, int prevIndex, int[] nums, int mask){
        if(i==nums.length) return 1;
        if(dp[i][prevIndex][mask]!=null) return dp[i][prevIndex][mask];
        int count = 0;
        for(int j=0;j<nums.length;j++){
            if((mask & (1<<j)) != 0) continue;
            if(mask==0 || nums[prevIndex]%nums[j]==0 || nums[j]%nums[prevIndex]==0){
                count = count%MOD + dfs(i+1,j,nums,(mask|(1<<j)))%MOD;
            }
        }
        return dp[i][prevIndex][mask]=count%MOD;
     
    }
}