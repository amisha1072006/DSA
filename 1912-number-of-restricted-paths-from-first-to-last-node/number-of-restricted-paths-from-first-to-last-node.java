class Solution {
           static final int mod = 1000000007;

    public int countRestrictedPaths(int n, int[][] edges) {

        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        int distance[]=new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq=new PriorityQueue<>((p1,p2)->p1.wt-p2.wt);
        pq.offer(new Pair(n,0));
        distance[n]=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int node=p.node;
            int wt=p.wt;
            if(wt>distance[node]) continue;
            for(Pair neig:adj.get(node)){
                int nnode=neig.node;
                int nwt=neig.wt;
                if(nwt+wt<distance[nnode]){
                    distance[nnode]=nwt+wt;
                    pq.offer(new Pair(nnode,distance[nnode]));
                }
            }
        }
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return countWays(adj,distance,1,n,dp);
    }
    public int countWays(List<List<Pair>> adj,int distance[],int s,int e,int dp[]){
        if(s==e) return 1;
        if(dp[s]!=-1){
            return dp[s];
        }
        int ways=0;
        for(Pair neig:adj.get(s)){
            int nnode=neig.node;
            if(distance[nnode]<distance[s]){
                ways=(ways+countWays(adj,distance,nnode,e,dp))%mod;
            }
        }
        return dp[s]=ways%mod;
    }
}
class Pair{
    int node,wt;
    public Pair(int node,int wt){
        this.node=node;
        this.wt=wt;  
    }
}