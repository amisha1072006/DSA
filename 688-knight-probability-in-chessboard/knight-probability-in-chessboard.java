class Solution {
    public double knightProbability(int n, int k, int row, int column) {
               int[][] moves = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1},
                         {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
        
        double[][][] dp = new double[k + 1][n][n];
        
        // Base case
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[0][i][j] = 1.0;
            }
        }
        
        // Fill DP
        for (int step = 1; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] move : moves) {
                        int x = i + move[0];
                        int y = j + move[1];
                        if (x >= 0 && x < n && y >= 0 && y < n) {
                            dp[step][i][j] += dp[step - 1][x][y] / 8.0;
                        }
                    }
                }
            }
        }
        
        return dp[k][row][column];
 
    }
}