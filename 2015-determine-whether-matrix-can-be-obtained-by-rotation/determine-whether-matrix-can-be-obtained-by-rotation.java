class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i=0; i<4; i++){
            if(check(mat, target))
                return true;
            rotate(mat);
        }
        return false;
    }
    //method to compare the given matrix with target matrix
    public boolean check(int[][] mat, int[][] target){
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] != target[i][j])
                    return false;
            }
        }
        return true;
    }
    
    public void rotate(int[][] mat){
		//transpose the matrix, transpose means first row becomes first column in matrix
        transpose(mat);
		//then we rotate the column
        for(int i=0; i<mat.length; i++){
            int left =0, right = mat.length-1;
            while(left<right){
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }   
        }
    }
    //In transpose arr[i][j] becomes arr[j][i] 
    public void transpose(int[][] mat){
       for(int i=0; i<mat.length; i++){
           for(int j=i; j<mat[0].length; j++){
               int temp = mat[i][j];
               mat[i][j] = mat[j][i];
               mat[j][i] = temp;
           }
    }
}
}