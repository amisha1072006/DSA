class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
       int[][] ans = new int[grid.length-k+1][grid[0].length-k+1];
        for(int i = 0;i<ans.length;i++){
            for(int j = 0;j<ans[0].length;j++){
                int[] arr = new int[k*k];
                int z = 0;
                for(int m = i;m<i+k;m++){
                    for(int l = j;l<j+k;l++){
                        arr[z++] = grid[m][l];
                   }
                }
                Arrays.sort(arr);
                int minsum = Integer.MAX_VALUE;
                boolean present = true;
                for(int y = 0;y<arr.length-1;y++){
                    int diff = Math.abs(arr[y]-arr[y+1]);
                    if(arr[y]==arr[y+1])continue;
                    else if(diff<=minsum){
                        minsum = diff;
                        present = false;
                    }
                }
                if(present)ans[i][j] = 0;
                else ans[i][j] = minsum;
            }
        }
        return ans;
    
    }
}