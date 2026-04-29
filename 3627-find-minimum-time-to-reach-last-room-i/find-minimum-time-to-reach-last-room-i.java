class Solution {
    public int minTimeToReach(int[][] moveTime) {
                int n = moveTime.length, m =  moveTime[0].length;
        int[][] directions = { {0,1}, {1,0}, {0,-1}, {-1,0} };

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->a[2]-b[2]);
        pq.offer(new int[]{0,0,0});
        
        int[][] cost = new int[n][m];
        for(int i =0; i < n; i++)Arrays.fill(cost[i], Integer.MAX_VALUE);
        cost[0][0] = 0;

        while(!pq.isEmpty()){
            int[] point = pq.poll();
            int t = point[2];
            if(point[0]==n-1 && point[1]==m-1)return t;

            for(int[] dir : directions){
                int nr = point[0]+dir[0], nc = point[1]+dir[1];
                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;

                int newCost = Math.max(t+1, moveTime[nr][nc]+1);
                if(cost[nr][nc] <= newCost)continue;

                cost[nr][nc] = newCost;
                pq.offer(new int[]{nr, nc, newCost});
            }
        }
        return cost[n-1][m-1];

    }
}