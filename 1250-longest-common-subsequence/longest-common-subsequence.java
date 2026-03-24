class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int m = text1.length();
        int n = text2.length();

        // plus 1 cuz empty string
        int[][] matrix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // if match found, plus 1 to diagonal
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    matrix[i][j] = 1 + matrix[i - 1][j - 1];
                } else {
                // if no match , get the max from top and left
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }

            }
        }

        // get the final answer from end of the table
        return matrix[m][n];  
    }
}