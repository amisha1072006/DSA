class Solution {
    public int firstMissingPositive(int[] nums) {
                int l=nums.length;
        int[] a=new int[l];
        int j=0;
        for(int i=0;i<l;i++){
            if(nums[i]>0){
                a[j]=nums[i];
                j++;
            }
        }
        Arrays.sort(a,0,j);
        int k=1;
        for(int i = 0; i < j; i++){
            if(a[i] == k){
                k++;
            }
        }

        return k;
    }
}