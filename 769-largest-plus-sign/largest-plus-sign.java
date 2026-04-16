class Solution {
            public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, n);
        Set<String> zero = new HashSet<>();
        for (int[] m : mines) zero.add(m[0] + "," + m[1]);

        for (int r = 0; r < n; r++) {
            int l = 0, rgt = 0;
            for (int c = 0, d = n - 1; c < n; c++, d--) {
                l = zero.contains(r + "," + c) ? 0 : l + 1;
                dp[r][c] = Math.min(dp[r][c], l);
                rgt = zero.contains(r + "," + d) ? 0 : rgt + 1;
                dp[r][d] = Math.min(dp[r][d], rgt);
            }
        }
int ans = 0;
        for (int c = 0; c < n; c++) {
            int u = 0, dwn = 0;
            for (int r = 0, x = n - 1; r < n; r++, x--) {
                u = zero.contains(r + "," + c) ? 0 : u + 1;
                dp[r][c] = Math.min(dp[r][c], u);
                dwn = zero.contains(x + "," + c) ? 0 : dwn + 1;
                dp[x][c] = Math.min(dp[x][c], dwn);
            }
        }

        for (int[] row : dp)
            for (int v : row) ans = Math.max(ans, v);
        return ans;

    }
}