class Solution {
    public int[] findPeakGrid(int[][] matrix) {

      // BRUTE FORCE APPROACH
      // TC = O(n * m), SC = O(1)

//         int n = matrix.length;
//         int m = matrix[0].length;
//         int[] ans = new int[2];
//         int maxElement = matrix[0][0];
//         for(int i = 0; i<n; i++){
//             for(int j = 0; j<m; j++){
//                 if(matrix[i][j] > maxElement){
//                     maxElement = matrix[i][j];
//                     ans[0] = i;
//                     ans[1] = j;
//                 }
//             }
//         }
//         return ans;
//     }
// }

     // OPTIMAL APPROACH
     // TC = O(), SC = O()

        int n = matrix.length;
        int m = matrix[0].length;
        int[] ans = new int[2];
        int low = 0;
        int high = m-1;
        while(low <= high){
            int mid = (low + high) / 2;
            int row = findMax(matrix, mid, n);
            int left = mid - 1 >= 0 ? matrix[row][mid-1] : -1;
            int right = mid + 1 <= m-1 ? matrix[row][mid+1] : -1;
            if(matrix[row][mid] > left && matrix[row][mid] > right){
                return new int[] {row, mid};
            }
            else if(matrix[row][mid] < left){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }
    public static int findMax(int[][] matrix, int mid, int n){
        int maxElement = -1;
        int index = -1;
        for(int i = 0; i<n; i++){
            if(matrix[i][mid] > maxElement){
                maxElement = matrix[i][mid];
                index = i;
            }
        }
        return index;
    }
}