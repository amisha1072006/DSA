class Solution {
            public int numFriendRequests(int[] ages) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:ages){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int res=0;
        for(int i:map.keySet()){
            for(int j:map.keySet()){
                if(check(i,j)){
                    res+=map.get(i)*(map.get(j)-(i==j ? 1:0));
                }
            }
        }
        return res;
    }
    public boolean check(int a,int b){
        return !(b<=0.5*a+7 || b>a || (b>100 && a<100));
    }
}