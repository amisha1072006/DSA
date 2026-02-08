class Solution {
    public int longestPalindromeSubseq(String s) {
           return solve(s,new StringBuilder(s).reverse().toString());
    }
    public static int solve(String text1,String text2){
        int[][]arr=new int[text1.length()][text2.length()];
        for(int []row:arr) Arrays.fill(row,-1);
        return helper(text1,text2,text1.length()-1,text2.length()-1,arr);
    }

    private static int helper(String text1, String text2, int index1, int index2, int[][] dp) {
        if(index1<0||index2<0)return 0;
        if(dp[index1][index2]!=-1)return dp[index1][index2];
        if(text1.charAt(index1)==text2.charAt(index2))return dp[index1][index2]=1+helper(text1,text2,index1-1,index2-1,dp);
        return dp[index1][index2]=Math.max(helper(text1,text2,index1-1,index2,dp),helper(text1,text2,index1,index2-1,dp));
    
    }
}