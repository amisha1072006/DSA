class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
                int n = 0;
        for(int[] edge : edges){
            n = Math.max(n,Math.max(edge[0],edge[1]));
        }

        int[] cand1 = null;
        int[] cand2 = null;

        int[] parent = new int[n+1];
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(parent[v] == 0){
                parent[v] = u;
            }
            else{
                cand1 = new int[]{parent[v],v};
                cand2 = new int[]{u,v};

                edge[1] = 0;
            }
        }
 
        Disjoint ds = new Disjoint(n+1);
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            if(!ds.unionBySize(u,v)){
                if(cand1 != null) return cand1;
                return edge;
            }
        }
        return cand2;
    }
}
class Disjoint{
    int[] parent;
    int[] size;
    public Disjoint(int n){
        parent = new int[n];
        size = new int[n];
        Arrays.fill(size,1);

        for(int i = 0;i < n;i++){
            parent[i] = i;
        }
    }

    public boolean unionBySize(int u,int v){
        int parentU = findParent(u);
        int parentV = findParent(v);

        if(parentU == parentV) return false;

        if(size[parentU] < size[parentV]){
            parent[parentU] = parentV;
            size[parentV] += size[parentU];
        }
        else{
           parent[parentV] = parentU;
           size[parentU] += size[parentV];  
        }
        return true;
    }

    public int findParent(int node){
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);

    }
}