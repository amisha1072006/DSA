class Solution {
    public int[] processQueries(int[] queries, int m) {
               List<Integer> ls = new ArrayList<>();
        int ans [] = new int[queries.length];
        for(int i=1;i<=m;i++) ls.add(i);
        for(int i=0;i<queries.length;i++){
            int pos = find(queries[i],ls);
            ans[i] = pos;
            ls.remove(pos);
            ls.add(0,queries[i]);
        }
        return ans;
    }
    public int find(int num, List<Integer> p){
        for(int i=0;i<p.size();i++){
            if(p.get(i)==num) return i;
        }
        return -1;
     
    }
}