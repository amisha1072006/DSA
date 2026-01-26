class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //Brute force approach

        // for(int i=0;i <= matrix.length-1;i++){
        //     for(int j =0;j<= matrix[0].length-1;j++){
        //         if(matrix[i][j]== target){
        //             return true;
        //         }

        //         }
        //     }
        //     return false;
        // }
        // OPTMISED APPROACH
        int col = 0 , row = matrix.length-1;
        while(col<matrix[0].length && row >=0){
            if(matrix[row][col] == target){
                return true;
            }
            else if(target<matrix[row][col]){
                row --;
            }
            else {
                col++;
            }
        }
        return false;
        }

    }
