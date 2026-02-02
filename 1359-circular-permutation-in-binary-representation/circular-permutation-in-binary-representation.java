class Solution {
    public List<Integer> circularPermutation(int n, int start) {
               List<Integer> list = new ArrayList<>();
        int N = 1<<n ;
        for(int i=0;i<N;i++){
            list.add(start^(i^(i>>1)));
        }
        return list;
     
    }
}