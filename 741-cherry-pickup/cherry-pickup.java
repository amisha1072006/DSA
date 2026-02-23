class Solution {
    int fun(int r1, int c1, int r2, int n, int[][] grid,int[][][] dp) {
        int c2 = r1 + c1 - r2;
        if (r1 < 0 || c1 < 0 || r2 < 0 || c2 < 0 || r1 >= n || c1 >= n || r2 >= n || c2 >= n
                || grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;
        if (r1 == n - 1 && c1 == n - 1)
            return grid[r1][c1];
            if(dp[r1][c1][r2]!=-1)return dp[r1][c1][r2];
        int cherries = (r1 == r2 && c1 == c2) ? grid[r1][c1] : grid[r1][c1] + grid[r2][c2];

        int maxval = Math.max(
                Math.max(fun(r1 + 1, c1, r2 + 1, n, grid,dp), fun(r1, c1 + 1, r2, n, grid,dp)),
                Math.max(fun(r1 + 1, c1, r2, n, grid,dp), fun(r1, c1 + 1, r2 + 1, n, grid,dp)));
        cherries += maxval;
        return dp[r1][c1][r2]=cherries;
    }

    public int cherryPickup(int[][] grid) {
               int n = grid.length;
        int[][][] dp = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {
                    dp[i][j1][j2] = -1;
                }
            }
        }
        int ans = fun(0, 0, 0, n, grid,dp);
        return Math.max(0, ans); 
    }
}