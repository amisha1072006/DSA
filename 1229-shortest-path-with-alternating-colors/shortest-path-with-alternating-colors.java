class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
       int[][] graph = new int[n][n];
        for(int[] arr: graph){
            Arrays.fill(arr, n);
        }

        for(int[] edge: redEdges){
            graph[edge[0]][edge[1]]=1;
        }

        //1 for red, 0 for both, -1 for blue
        for(int[] edge: blueEdges){
           if(graph[edge[0]][edge[1]]==1){
                graph[edge[0]][edge[1]]=0;
           }else{
                graph[edge[0]][edge[1]]=-1;
           }
        }

        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0]=0;

        int len = 0;

        Set<String> visited = new HashSet<>();

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 1});
        q.add(new int[]{0,-1});


        while(!q.isEmpty()){
            int size = q.size();
            len++;
            for(int i=0; i<size; i++){
                int[] current = q.poll();
                int node = current[0];
                int color = current[1];
                int oppColor = -color;

                for(int j=0; j<n; j++){
                    if(graph[node][j] == oppColor || graph[node][j]==0){
                        if(!visited.contains(j+""+oppColor)){
                            q.add(new int[]{j, oppColor});
                            res[j] = Math.min(res[j], len);
                            visited.add(j+""+oppColor);
                        }
                    }
                }


            }
        }

        for(int i=1; i<n; i++){
            if(res[i]==Integer.MAX_VALUE){
                res[i]=-1;
            }
        }

        return res;  
    }
}