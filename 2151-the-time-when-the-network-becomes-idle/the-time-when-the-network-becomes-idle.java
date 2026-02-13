class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
               List<List<Integer>> adjList = new ArrayList<>();
        int n = patience.length;
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while(!q.isEmpty())
        {
            int node = q.poll();
            for(int adjNode : adjList.get(node))
            {
                if(dist[node] + 1 < dist[adjNode])
                {
                   dist[adjNode] = dist[node]+1;
                   q.add(adjNode);
                }
            }
        }
        int maxLastArrival = 0;
        for(int i=1; i<n; i++)
        {
            int firstArrival = 2*dist[i];
            int lastArrival = 0;
            if(patience[i] >= firstArrival)
            {
                lastArrival = firstArrival; // last sent will be zero
            }
            else
            {
                int lastSent = (firstArrival - 1)/patience[i] * patience[i];
                lastArrival = lastSent + 2*dist[i];
            } 
            maxLastArrival = Math.max(lastArrival, maxLastArrival);
        }
        return maxLastArrival+1;
     
    }
}