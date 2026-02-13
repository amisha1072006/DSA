class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
               List<List<Integer>>graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        } 
        for(int d[]:dislikes){
            graph.get(d[0]).add(d[1]);
            graph.get(d[1]).add(d[0]);
        }
        int col[]=new int[n+1];
        for (int i=0;i<=n;i++){
            col[i]=-1;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<=n;i++){
            if(col[i]==-1){
                q.add(i);
                col[i]=0;
                while(!q.isEmpty()){
                    int curr=q.remove();
                    for(int j=0;j<graph.get(curr).size();j++){
                        int e=graph.get(curr).get(j);
                        if(col[e]==-1){
                            col[e]=1-col[curr];
                            q.add(e);
                        }
                        else if(col[e]==col[curr]){
                            return false;
                        }
                    }
                    
                }
               
            }
        }
    
        return true;
 
    }
}