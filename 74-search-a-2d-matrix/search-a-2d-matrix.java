class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //BRUTE FORCE APPROACH
        // TC = O(n * m), SC = O(1)

//         for(int i=0;i <= matrix.length-1;i++){
//             for(int j =0;j<= matrix[0].length-1;j++){
//                 if(matrix[i][j]== target){
//                     return true;
//                 }
//              }
//          }
//      return false;
//     }
// }

      // BETTER APPROACH
      // TC = O(n + logm), SC = O(1)

//         int n = matrix.length;
//         int m = matrix[0].length;
//         for(int i = 0; i<n; i++){
//             if(matrix[i][0] <= target && target <= matrix[i][m-1]){
//                 return binaryFunc(matrix[i], target);
//             }
//         }
//         return false;
//     }
//     public static boolean binaryFunc(int[] matrix, int target){
//         int n = matrix.length;
//         int left = 0;
//         int right = n-1;
//         while(left <= right){
//             int mid = (left + right) / 2;
//             if(matrix[mid] == target){
//                 return true;
//             }
//             else if(matrix[mid] < target){
//                 left = mid + 1;
//             }
//             else{
//                 right = mid - 1;
//             }
//         }
//         return false;
//     }
// }

        // OPTMISED APPROACH
        // TC = O(log(m * n)), SC = O(1)

        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = (n * m) - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(matrix[mid / m][mid % m] == target){
                return true;
            }
            else if(matrix[mid / m][mid % m] < target){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return false;
    }
}

        