class Solution {
    public void solve(char[][] board) {
       int[]delRow={-1,0,1,0};
        int[]delCol={0,1,0,-1};
        int n=board.length,m=board[0].length;
        int[][]visited=new int[n][m];
        //check 0 in first & last row
        for(int i=0;i<m;i++){
            //first row
            if(visited[0][i]==0&&board[0][i]=='O'){
                dfs(0,i,visited,board,delRow,delCol);
            }
            //last row
            if(visited[n-1][i]==0&&board[n-1][i]=='O'){
                dfs(n-1,i,visited,board,delRow,delCol);
            }
        }
        //check 0 in first and last col
        for(int i=0;i<n;i++){
            //first col
            if(visited[i][0]==0&&board[i][0]=='O'){
                dfs(i,0,visited,board,delRow,delCol);
            }
            //last col
            if(visited[i][m-1]==0&&board[i][m-1]=='O'){
                dfs(i,m-1,visited,board,delRow,delCol);
            }
        }
        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if(visited[i][j]==0)board[i][j]='X';
            }
        }
    }
    public static void dfs(int row,int col,int [][]visited,char[][]board,int[]delRow,int[]delCol){
        visited[row][col]=1;
        int n=board.length,m=board[0].length;
        for(int i=0;i<4;i++){
            int newRow=row+delRow[i];
            int newCol=col+delCol[i];
            if(newRow>=0&&newRow<n&&newCol>=0&&newCol<m&&
                    visited[newRow][newCol]==0&&board[newRow][newCol]=='O'){
                dfs(newRow,newCol,visited,board,delRow,delCol);
            }
        } 
    }
}