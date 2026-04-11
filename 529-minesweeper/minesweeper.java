class Solution {
      int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}};

    public void makeBlank(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == 'B' || board[r][c] == 'M' || (board[r][c] - '0' > 0 && board[r][c] - '0' < 9)) return;

        if (numBombs(board, r, c) != 0) {
            board[r][c] = Integer.toString(numBombs(board, r, c)).charAt(0);
            return;
        } else board[r][c] = 'B';

        for (int[] dir : dirs) {
            int x = r + dir[0];
            int y = c + dir[1];
            makeBlank(board, x, y); 
        }   
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        char ch = board[click[0]][click[1]];

        if (ch == 'M') {
            board[click[0]][click[1]] = 'X';
        } else {
            if (numBombs(board, click[0], click[1]) == 0) {
                board[click[0]][click[1]] = 'B';
                for (int[] dir : dirs) {
                    int x = click[0] + dir[0];
                    int y = click[1] + dir[1];
                    makeBlank(board, x, y); 
                }
            } else board[click[0]][click[1]] = Integer.toString(numBombs(board, click[0], click[1])).charAt(0);
        }

        return board;
    }

    public int numBombs(char[][] board, int r, int c) {
        int b = 0;
        for (int[] dir : dirs) {
            int x = r + dir[0];
            int y = c + dir[1];

            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] == 'M') b++; 
        }

        return b;  
    }
}