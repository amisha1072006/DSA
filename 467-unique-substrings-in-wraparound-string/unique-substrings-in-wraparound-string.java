class Solution {
    public int findSubstringInWraproundString(String s) {
       int[] dp = new int[26];
        int currLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && 
               (s.charAt(i) - s.charAt(i - 1) == 1 ||
                s.charAt(i - 1) == 'z' && s.charAt(i) == 'a')) {
                currLen++;
            } else {
                currLen = 1;
            }

            int idx = s.charAt(i) - 'a';
            dp[idx] = Math.max(dp[idx], currLen);
        }

        int result = 0;
        for (int val : dp) result += val;
        return result;     
     
    }
}