class Solution {
    public void setZeroes(int[][] matrix) {
    //     int n = matrix.length;
    //     int m = matrix[0].length;
    //    int matrix1[][] = new int[n][m];
    //    for(int i = 0; i < matrix.length; i++) {
    //     for(int j = 0; j < matrix[0].length; j++) {
    //          matrix1[i][j] = matrix[i][j];
    //     }
    //    }

    // for(int i = 0; i < matrix.length; i++) {
    //     for(int j = 0; j < matrix[0].length; j++) {
    //         if(matrix[i][j] == 0) {
    //         for(int k = 0; k<matrix.length; k++){
    //             matrix1[k][j] = 0;
    //         }
    //         for(int l = 0; l<matrix[0].length; l++){
    //             matrix1[i][l] = 0;
    //         }
    //         }
    //     }
    // }
    // for(int i = 0; i < matrix.length; i++) {
    //     for(int j = 0; j < matrix[0].length; j++) {
    //          matrix[i][j] = matrix1[i][j];
    //     }
    //    }


   boolean[] zeroRow = new boolean[matrix.length];
   boolean[] zeroCol = new boolean[matrix[0].length];
    for(int i = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix[0].length; j++) {
            if(matrix[i][j] == 0) {
              zeroRow[i] = true;
              zeroCol[j] = true;
            }
        }
    }
    for(int i = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix[0].length; j++) {
            if(zeroRow[i] || zeroCol[j]){
               matrix[i][j] = 0;
            }
        }
       }

    }
    }
