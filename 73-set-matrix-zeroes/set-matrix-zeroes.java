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

  // BETTER APPROACH
  // TC = O(n*m), SC = O(n+m)

//    int[] zeroRow = new int[matrix.length];
//    int[] zeroCol = new int[matrix[0].length];
//     for(int i = 0; i < matrix.length; i++) {
//         for(int j = 0; j < matrix[0].length; j++) {
//             if(matrix[i][j] == 0) {
//               zeroRow[i] = 1;
//               zeroCol[j] = 1;
//             }
//         }
//     }
//     for(int i = 0; i < matrix.length; i++) {
//         for(int j = 0; j < matrix[0].length; j++) {
//             if(zeroRow[i] == 1 || zeroCol[j] == 1){
//                matrix[i][j] = 0;
//             }
//         }
//        }

// OPTIMAL APPROACH 
// TC = O(n*m), SC = O(1)

int col0 = 1;
int n = matrix.length; 
int m = matrix[0].length;
for(int i = 0; i<n; i++){
  for(int j = 0; j<m; j++){
    if(matrix[i][j] == 0){
        matrix[i][0] = 0;
        if(j != 0){
            matrix[0][j] = 0;
        }
        else{
            col0 = 0;
        }
    }
  }
}
 for(int i = 1; i<n; i++){
    for(int j = 1; j<m; j++){
        if(matrix[i][j] != 0){
            // check for row and coloumn
            if(matrix[i][0] == 0 || matrix[0][j] == 0){
                matrix[i][j] = 0;
            }
        }
    }
 }
 if(matrix[0][0] == 0){
    for(int j = 0; j<m; j++){
        matrix[0][j] = 0;
    }
 }
 if(col0 == 0){
    for(int i = 0; i<n; i++){
        matrix[i][0] = 0;
    }
 }
    }
    }
