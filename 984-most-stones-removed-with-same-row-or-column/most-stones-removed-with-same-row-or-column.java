class Solution {
    static class DSJ{
        List<Integer>rank=new ArrayList<>();
        List<Integer>parent=new ArrayList<>();
        DSJ(int n){
            for(int i=0;i<n;i++){
                rank.add(0);
                parent.add(i);
            }
        }
        public int findParent(int node){
            if(node==parent.get(node))return node;
            int ultiMateParent=findParent(parent.get(node));
            parent.set(node,ultiMateParent);
            return ultiMateParent;
        }
        public void unionByRank(int u,int v){
            int ultiMateParentU=findParent(u);
            int ultiMateParentV=findParent(v);
            if(ultiMateParentV==ultiMateParentU)return;
            if(rank.get(ultiMateParentU)<rank.get(ultiMateParentV))parent.set(ultiMateParentU,ultiMateParentV);
            else if(rank.get(ultiMateParentV)<rank.get(ultiMateParentU))parent.set(ultiMateParentV,ultiMateParentU);
            else {
                parent.set(ultiMateParentV,ultiMateParentU);
                int rankU=rank.get(ultiMateParentU);
                rank.set(ultiMateParentU,rankU+1);
            }
        }
    }
    public int removeStones(int[][] stones) {
                int n=stones.length;
        DSJ dsj=new DSJ(n);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0]||stones[i][1]==stones[j][1]){
                    dsj.unionByRank(i,j);
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(dsj.findParent(i)==i)ans++;
        }
        return n-ans;

    }
}