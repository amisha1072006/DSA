class Solution {
    public long maxMatrixSum(int[][] matrix) {
                long sum = 0; 
        int negative_count = 0;
        int min_abs = Integer.MAX_VALUE; 

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int num = matrix[i][j];
                sum += Math.abs((long) num); 
                if (num < 0) {
                    negative_count++;
                }
                min_abs = Math.min(min_abs, Math.abs(num));
            }
        }

        if (negative_count % 2 == 0) {
            return sum;
        } else {
            return sum - 2 * min_abs;
        }

    }
}