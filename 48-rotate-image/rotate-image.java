class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // BRUTE FORCE APPROACH 
        // TC = O(n^2), SC = O(n^2)

        // Step 1: Transpose the matrix
        // int[][] transpose = new int[n][n];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         transpose[j][i] = matrix[i][j];
        //     }
        // }

        // Step 2: Reverse each row
        // TC = O(n * n/2) = O(n^2)
        // for (int i = 0; i < n; i++) {
        //     int j = 0 , k = n-1;
            // TC OF WHILE LOOP IS O(n/2)
        //     while(j<k){
        //        int temp = transpose[i][j];
        //        transpose[i][j] = transpose[i][k];
        //        transpose[i][k] = temp;
        //        j++;
        //        k--;
        //     }
        // }
        // step 3 copy all the elements from transpose to matrix
        //     for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         matrix[i][j] = transpose[i][j] ;
        //     }
        // }


        // OPTIMAL APPROACH
        // TC = O(n^2), SC = O(1)
 
       // transpose the matrix
        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // reverse the matrix
        // TC = O(n * n/2) = O(n^2)
        for (int i = 0; i < n; i++) {
            int j = 0 , k = n-1;
            // TC OF WHILE LOOP IS O(n/2)
            while(j<k){
               int temp = matrix[i][j];
               matrix[i][j] = matrix[i][k];
               matrix[i][k] = temp;
               j++;
               k--;
            }
        }

    }
}