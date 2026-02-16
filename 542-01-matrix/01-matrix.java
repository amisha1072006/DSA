class Solution {
    public int[][] updateMatrix(int[][] mat) {
               int m = mat.length, n = mat[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[m][n];
        int INF = Integer.MAX_VALUE;

        // Step 1: Initialize dist
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 2: Multi-source BFS
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    if (dist[nr][nc] > dist[r][c] + 1) {
                        dist[nr][nc] = dist[r][c] + 1;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return dist;
 
    }
}