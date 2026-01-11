class Solution {
    static class BIT{
        private int [] tree;
        private int n;

        public BIT(int size){
            n = size+2;
            tree = new int[n];
        }

        public void update (int i, int val){
            while(i<n){
                tree[i]+=val;
                i+=i &-i;
            }
        }

        public int query(int i){
            int sum=0;
            while(i>0){
                sum+=tree[i];
                i-=i & -i;
            }
            return sum;
        }
    }
        
    public long minInversionCount(int[] nums, int k) {
                int []cp  =nums;
        int n = cp.length;

        int [] sorted = cp.clone();
        Arrays.sort(sorted);
        int [] compressed = new int[n];

        for(int i=0;i<n;i++){
            compressed[i] = Arrays.binarySearch(sorted,cp[i])+1;
        }

        BIT bit = new BIT(n+2);
        long inversions =0;
        for(int i=0;i<k;i++){
            inversions +=i-bit.query(compressed[i]);
            bit.update(compressed[i],1);
        }

        long minInv = inversions;

        for(int i=k;i<n;i++){
            bit.update(compressed[i-k],-1);
            inversions -= bit.query(compressed[i-k]-1);

            inversions +=(k-1)- bit.query(compressed[i]);
            bit.update(compressed[i],1);

            minInv = Math.min(minInv,inversions);
        }
        return minInv;
    
    }
}