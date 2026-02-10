class Solution {
        HashMap<String,Integer> map;

    public int minimumXORSum(int[] nums1, int[] nums2) {
                map = new HashMap();
        return minXORSumHelper(nums1,0,nums2,0);
    }
    public int minXORSumHelper(int nums1[] , int idx , int nums2[] , int mask){
        if(idx==nums1.length) return 0; // base case 
        String key = idx+"#"+mask; // idx and mask are changing so use it as a key to memoize 
        // can also memoize using only mask since idx depends on mask 
        if(map.get(key)!=null) return map.get(key);
        int min = Integer.MAX_VALUE;
        for(int i =0;i<nums2.length;i++){ // look at all possible ways to generate answer for current subproblem 
            if((mask&(1<<i))==0){
                int curr = (nums1[idx] ^ nums2[i]) + minXORSumHelper(nums1,idx+1,nums2,mask|(1<<i));
            // have faith in your recursive function , it WILL solve rest of the subproblem 
                min = Math.min(curr,min);
            }
        }
        // min stores minimum xor sum for current subproblem 
        map.put(key,min);
        return min;

    }
}