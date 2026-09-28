class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int startRow = 0;
        int endRow = n-1;
        int startCol = 0;
        int endCol = m-1;
        ArrayList<Integer> list = new ArrayList<>();
        while(startRow <= endRow && startCol <= endCol){
            // top
            for(int j = startCol; j<= endCol; j++){
                 list.add(matrix[startRow][j]);
            }
            //right
            for(int i = startRow+1; i<= endRow; i++){
                 list.add(matrix[i][endCol]);
            }
            //bottom
            for(int i = endCol-1; i>= startCol; i--){
                if(startRow == endRow){
                    break;
                }
                list.add(matrix[endRow][i]);
            }
            //left
            for(int i = endRow-1; i>=startRow + 1; i--){
                if(startCol == endCol){
                    break;
                }
                list.add(matrix[i][startCol]);
            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
        return list;
    }
}