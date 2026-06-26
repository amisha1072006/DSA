class Solution {
    public boolean isBipartite(int[][] graph) {
                int n = graph.length;
        int[] color = new int[n]; 
        
        for(int i = 0; i < n; i++){
            if(color[i] != 0) continue;

            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            color[i] = 1;

            while(!q.isEmpty()){
                int node = q.poll();

                for(int nei : graph[node]){
                    if(color[nei] == 0){
                        color[nei] = -color[node];
                        q.offer(nei);
                    }
                    else if(color[nei] == color[node]){
                        return false;
                    }
                }
            }
        }

        return true;

    }
}