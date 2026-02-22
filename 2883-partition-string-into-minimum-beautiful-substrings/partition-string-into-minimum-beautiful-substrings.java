class Solution {
        private int solve(String s, int start, int end, int dp[][]) {
        if(s.charAt(start) == '0') return Integer.MAX_VALUE;
        
        if(dp[start][end] != -1) return dp[start][end];
        
        String str = s.substring(start,end+1);
        int num = Integer.parseInt(str,2); 
        if(isPowerOfFive(num)) return 1;

        int res = Integer.MAX_VALUE;
        for(int i = start;i<end;i++){
            int a = solve(s,start,i,dp);
            int b = solve(s,i+1,end,dp); 
            if(a!=Integer.MAX_VALUE && b!= Integer.MAX_VALUE) {
                res = Math.min(res,a+b);
            }
        }
        return dp[start][end] = res;
    }

    private boolean isPowerOfFive(int n) {
        while(n%5 == 0) {
            n/=5;
        }
        return n == 1;
    }

    public int minimumBeautifulSubstrings(String s) {
        int n = s.length();
        int dp[][] = new int[n+1][n+1];
        Arrays.stream(dp).forEach(row->Arrays.fill(row,-1));
        int res = solve(s,0,n-1,dp);
        return  res == Integer.MAX_VALUE ? -1 : res; 
    }
}