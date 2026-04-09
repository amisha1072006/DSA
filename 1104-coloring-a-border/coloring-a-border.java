class Solution {
        int defaults = 0; 
    int dir[][] = {{1, 0} , {-1 , 0} , {0 , 1} , { 0 , -1}}; 

    public void dfs(int[][] grid , int r ,int c , int color , boolean[][] visited)
    {
        int count = 0; 
        visited[r][c] = true; 
        grid[r][c] = color; 
        for(int d = 0 ; d < 4 ; d++)
        {
            int x = r + dir[d][0]; //r =  1 + 1 = 2
            int y = c + dir[d][1]; //c =  1 + 0 = 1 
            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) //valid posiiton 
            {
                if(visited[x][y] == true)
                   count++;     
                else
                {
                    if(grid[x][y] == defaults) //not visited and 
                    {
                        count++;  
                        dfs(grid , x , y , color , visited); 
                    }
                }
            }
            if(count == 4)
                grid[r][c] = defaults;  
        }
    }
    
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int m = grid.length;
        int n = grid[0].length;  
        boolean[][] visited = new boolean[m][n];
        
        defaults = grid[r0][c0]; 
        dfs(grid , r0 , c0, color , visited); 
        return grid; 
    }
}