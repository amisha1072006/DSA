class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        boolean[][] visited = new boolean[r][c];

        int max = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == 1 && visited[i][j] == false) {
                int area = dfs(i,j, grid, visited);
                max = Math.max(max, area);
                }
            }
        }

        return max;
    }

    public int dfs(int row, int col, int[][] grid, boolean[][] visited) {
        // current cell checking
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || visited[row][col] == true || grid[row][col] == 0) {
            return 0;
        }
       
        visited[row][col] = true;
        
        // explore next 4 cells
        return 1 + dfs(row, col - 1, grid, visited) + 
                   dfs(row, col + 1, grid, visited) + 
                   dfs(row - 1, col, grid, visited) + 
                   dfs(row + 1, col, grid, visited);
    }
}