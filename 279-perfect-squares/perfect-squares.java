class Solution {
    public int numSquares(int n) {
       int[] dp = new int[n + 1];

        // Base case: 0 needs 0 squares.  (Like saying, "To make zero cookies, you need zero ingredients.")
        dp[0] = 0;

        // Iterate through each number from 1 to n.
        for (int i = 1; i <= n; i++) {
            // Initialize the minimum number of squares needed for 'i' to 'n' (a large number).
            // We assume the worst-case scenario initially (using only 1s).
            dp[i] = n;

            // Check all perfect squares less than or equal to 'i'.
            for (int j = 1; j * j <= i; j++) {
                //  dp[i - j * j] is the minimum number of squares to get 'i - j*j'.
                //  So dp[i - j * j] + 1 is the number of squares we need if we use square number j*j
                // Take the minimum between:
                // 1. The current minimum number of squares for 'i' (dp[i]).
                // 2. The number of squares needed to make 'i - j*j' plus one more square (j*j).
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        // Return the minimum number of squares needed for 'n'.
        return dp[n];
     
    }
}