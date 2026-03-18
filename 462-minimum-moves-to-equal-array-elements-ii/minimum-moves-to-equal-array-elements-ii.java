class Solution {
    public int minMoves2(int[] nums) {
       Arrays.sort(nums);
        int len=(int)(nums.length/2);
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[len]!=nums[i]){
                int tmp=Math.abs(nums[len]-nums[i]);
                cnt+=tmp;
            }
        }
        return cnt;
 
    }
}