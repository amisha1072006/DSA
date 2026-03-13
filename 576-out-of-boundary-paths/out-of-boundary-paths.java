class Solution {
        int mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
       int dp[][][] = new int[m][n][maxMove + 1];

        for(int [][] i : dp) 
            for(int s1[] : i) {
                Arrays.fill(s1, -1);
            }
        
        return findPaths(m, n, maxMove, startRow, startColumn, dp);
    }

    public int findPaths(int m, int n, int N, int i, int j, int dp[][][]) {

        if(i == m || j == n || i < 0 || j < 0) return 1;
        if(N == 0) return 0;

        if(dp[i][j][N] >= 0) return dp[i][j][N];

        dp[i][j][N] = (
            (findPaths(m, n, N-1, i-1, j, dp) + findPaths(m, n, N-1, i+1, j, dp)) % mod +
            (findPaths(m, n, N-1, i, j-1, dp) + findPaths(m, n, N-1, i, j+1, dp)) % mod) % mod;
        
        return dp[i][j][N]; 
    }
}