class Solution {
        Integer[][] dp;
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        dp=new Integer[n][n];
        long total=0;
        for(int i:nums){
            total+=i;
        }
        int a=solve(nums,0,n-1);
        return a+a>=total;
    }
    public int solve(int[] a,int l,int r){
        if(l==r)return a[l];
        if(l>r)return 0;
        if(dp[l][r]!=null)return dp[l][r];
        

        int left=a[l]+Math.min(solve(a,l+2,r),solve(a,l+1,r-1));
        int right=a[r]+Math.min(solve(a,l+1,r-1),solve(a,l,r-2));
        return dp[l][r]=Math.max(left,right);
    }
}