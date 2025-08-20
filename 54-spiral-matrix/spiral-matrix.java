class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length,n=matrix[0].length;
        int srow = 0,scol=0,erow=m-1,ecol=n-1;
        List<Integer>ans = new ArrayList<>();
        while(srow <=erow && scol <=ecol){
            //top
            for(int j=scol;j<=ecol;j++){
                ans.add(matrix[srow][j]);
            }
            //right
            for(int i= srow+1;i<=erow;i++){
                ans.add(matrix[i][ecol]);
            }
            //bottom
            for(int j=ecol-1;j>=scol;j--){
                if(srow == erow){
                    break;
                }
                ans.add(matrix[erow][j]);
            }
            //left
            for(int  i=erow-1;i>=srow+1;i--){
                if(scol == ecol){
                    break;
                }
                ans.add(matrix[i][scol]);
            }
            srow++;erow--;scol++;ecol--;
        }
      return ans;
    }
}