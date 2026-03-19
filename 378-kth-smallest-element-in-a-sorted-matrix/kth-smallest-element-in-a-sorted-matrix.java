class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0];
        int r = matrix[n - 1][n - 1];

        while(l < r){
            int mid = l + (r - l) / 2;
            int count = countLess(matrix, mid);
            if(count >= k){
                r = mid;
            }
            else l = mid + 1;
        }

        return l;
    }

    private int countLess(int[][] matrix, int x){
        int cnt = 0;
        int r = 0, c = matrix.length - 1;

        while(r < matrix.length && c >= 0){
            if(matrix[r][c] <= x){
                cnt += c + 1;
                r++;
            }
            else c--;
        }

        return cnt;
    }
}