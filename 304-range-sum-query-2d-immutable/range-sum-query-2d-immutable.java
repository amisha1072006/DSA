class NumMatrix {
        int[][] matrix;

    public NumMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (col > 0) matrix[row][col] += matrix[row][col-1];
                if (row > 0) matrix[row][col] += matrix[row-1][col];
                if (row > 0 && col > 0) matrix[row][col] -= matrix[row-1][col-1];
            }
        }
        this.matrix = matrix;
    
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = matrix[row2][col2];
        if (col1 > 0) res -= matrix[row2][col1 - 1];
        if (row1 > 0) res -= matrix[row1 - 1][col2];
        if (col1 > 0 && row1 > 0) res += matrix[row1 - 1][col1 - 1];
        return res;
    
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */