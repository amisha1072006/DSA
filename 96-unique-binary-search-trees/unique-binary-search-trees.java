class Solution {
    public int numTrees(int n) {
                int dp[][] = new int[20][20];
        for(int r[]:dp){
            Arrays.fill(r,-1);
        }
        return rec(1,dp,n);
    }
    int rec(int i,int dp[][],int n){

        if(i>n){
            return 1;
        }
        if(dp[i][n]!=-1){
            return dp[i][n];
        }
        int cnt =0;
        for(int r = i;r<=n;r++){
            
            int left = rec(i,dp,r-1);
            int right = rec(r+1,dp,n);

            cnt += left*right;
        }
        return dp[i][n]=cnt;
   
    }
}