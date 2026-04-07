class Solution {
    public int smallestRangeII(int[] nums, int k) {
               Arrays.sort(nums);
        int n=nums.length;
        if(n==1) return 0;
        int res = nums[n-1]-nums[0];
        int first = nums[0]+k;
        int last = nums[n-1]-k;
        for(int i=0;i<n-1;i++){
            int min = Math.min(first,nums[i+1]-k);
            int max = Math.max(last,nums[i]+k);
            res = Math.min(res,max-min);
        }
        return res;
 
    }
}