class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        int[][] transpose = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            // for (int j = 0; j < n / 2; j++) {
            //     int temp = transpose[i][j];
            //     transpose[i][j] = transpose[i][n - j - 1];
            //     transpose[i][n - j - 1] = temp;
            // }
            int j = 0 , k = n-1;
            while(j<k){
               int temp = transpose[i][j];
               transpose[i][j] = transpose[i][k];
               transpose[i][k] = temp;
               j++;
               k--;
            }
        }
        // step 3 copy all the elements from transpose to matrix
            for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = transpose[i][j] ;
            }
        }

    }
}