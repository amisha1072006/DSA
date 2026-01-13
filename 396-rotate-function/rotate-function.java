class Solution {
    public int maxRotateFunction(int[] nums) {
       int n=nums.length;
        int res=Integer.MIN_VALUE;
        int sum=0;
        int sum2=0;
        for(int i=0;i<n;i++){
            sum+=(i*nums[i]);
            sum2+=nums[i];
        }
        int t=n-1;
        for(int i=0;i<n;i++){
            int temp=sum2-nums[t-i];
            int temp2=sum+temp-(t*nums[t-i]);
            res=Math.max(temp2,res);
            sum=temp2;

        }
        return res;
     
    }
}