class Solution {
    int m;
    int n;
    String word1;
    String word2;
    int[][] dp;

    int solve(int i, int j) {
        if (i == m)
            return n - j; // we must insert the remaining characters of word2 into word1
        if (j == n)
            return m - i; // we must delete the remaining characters of word1
        if (dp[i][j] != -1) return dp[i][j];
        if (word1.charAt(i) == word2.charAt(j))
            return dp[i][j] = solve(i + 1, j + 1);
        int delete = 1 + solve(i + 1, j);
        int replace = 1 + solve(i + 1, j + 1);
        int insert = 1 + solve(i, j + 1);
        return dp[i][j] = Math.min(Math.min(delete, replace), insert);
    }
    public int minDistance(String word1, String word2) {
       m = word1.length();
        n = word2.length();
        dp = new int[m][n];
        this.word1 = word1;
        this.word2 = word2;

        for (int[] row: dp)
            Arrays.fill(row, -1);
        return solve(0, 0); 
    }
}