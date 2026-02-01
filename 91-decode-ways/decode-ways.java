class Solution {
    public int numDecodings(String s) {
     int n = s.length();
        if (n == 0) return 0;

        int[] dp = new int[n + 1];

        // intialization - empty string 
        dp[0] = 1; 
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        // numbers must be present in between 1 - 26 - single or double digit
        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            int twoDigit = Integer.valueOf(s.substring(i - 2, i));

            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }

            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
       
    }
}