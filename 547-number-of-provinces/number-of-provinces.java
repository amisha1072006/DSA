class Solution {
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length; 
        int provinces =0;
        boolean[] visited = new boolean[isConnected.length];
        for(int city=0; city<cities;city++){
            if(!visited[city]){
                dfs(city, isConnected, visited);
                provinces++;
            }
        }

        return provinces;

    }
    public void dfs(int city, int[][] isConnected, boolean[] visited){
        visited[city]=true;
        for(int j=0; j<isConnected.length; j++){
            if(visited[j]!=true){
                if(isConnected[city][j]==1 && city!=j){
                    dfs(j, isConnected, visited);
                }
            }
        }
    }
}