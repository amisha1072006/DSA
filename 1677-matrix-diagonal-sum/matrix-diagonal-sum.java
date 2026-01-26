class Solution {
    public int diagonalSum(int[][] mat) {
        // BRUTE FORCE APPROACH
     ///   int sum = 0;
    //    for(int i = 0;i<mat.length;i++){
    //     for(int j = 0;j<mat[0].length;j++){
    //        if(i+j == (mat.length-1) || i==j){
    //         sum +=mat[i][j];
    //        }
    //     }
    //    } 
    //    return sum;
    // }

    //OPTMIZED APPROACH
     int sum = 0;
     for(int i=0; i< mat.length;i++){
        //primary diagnol
        sum += mat[i][i];
        //2 nd diagnol 
        if(i!= mat.length-1-i){
            sum += mat[i][mat.length-1-i];
        }
     }
     return sum;
    }
}