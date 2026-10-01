class Solution {
    public void setZeroes(int[][] matrix) {

    // BRUTE FORCE APPROACH
    //TC = O(n*m*(n+m)) OR TC = O(n^3) IF n = m, SC = O(n*m)

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

  // OPTIMAL APPROACH
  // TC = O(n*m), SC = O(n+m)

   int[] zeroRow = new int[matrix.length];
   int[] zeroCol = new int[matrix[0].length];
    for(int i = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix[0].length; j++) {
            if(matrix[i][j] == 0) {
              zeroRow[i] = 1;
              zeroCol[j] = 1;
            }
        }
    }
    for(int i = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix[0].length; j++) {
            if(zeroRow[i] == 1 || zeroCol[j] == 1){
               matrix[i][j] = 0;
            }
        }
       }

    }
    }
