class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
      int[] res = new int[queries.length];
        int ind = 0;
        for(int[] q: queries) {
            int lca = findLCA(q[0], q[1]);
            res[ind++] = findDist(q[0]) - findDist(lca) + findDist(q[1]) - findDist(lca) + 1;
        }
        return res;
        
        
    }
    public static int findLCA(int u, int v) {  
        int max = Math.max(u,v);
        int min = Math.min(u,v);
        HashSet<Integer> hset = new HashSet<>();
        while(max != 0) {
            hset.add(max);
            max = max/2;
        }
        while(min != 0) {
            if(hset.contains(min)) return min;
            min = min/2;
        }
        return 1;  
    }
    public static int findDist(int num) {
         int mssb = 0;
         while(num > 0) {
             num = num>>1;
             mssb++;
         }
        return mssb;
      
    }
}