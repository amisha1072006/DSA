class Solution {
        boolean[] isVis;
    void dfs(int a, int i, List<List<Integer>> adj){        
        if(i!=a){
            ans.get(a).add(i);
            isVis[i]=true;
        }
        for(int node:adj.get(i)){
            if(!isVis[node]){
                dfs(a,node,adj);
            }
        }
    }
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
            ans.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][1]).add(edges[i][0]);
            
        }
        for(int i=0;i<n;i++){
            isVis=new boolean[n];
            dfs(i,i,adj);
        }
        for(int i=0;i<ans.size();i++){            
            Collections.sort(ans.get(i));
        }
        return ans;
    }
}