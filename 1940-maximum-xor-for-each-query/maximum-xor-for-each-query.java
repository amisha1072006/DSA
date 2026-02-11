class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
               int[] ans= new int[nums.length];
        ans[0]= nums[0];
        for(int i=1; i<nums.length; i++){
            ans[i]= ans[i-1]^nums[i];
        }
        int n= (int)(Math.pow(2, maximumBit)-1);
        for(int i=0; i<nums.length; i++){
            ans[i]= ans[i]^n;
        }
        int l= 0, r= ans.length-1;
        while(l<r){
            int t= ans[l];
            ans[l]= ans[r];
            ans[r]=t;
            l+=1;
            r-=1;
        }
        return ans;
     
    }
}