class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        //OPTIMIZED APPROACH
        // TC = O(n), SC = O(1)
        int n = nums.length;
        int count = 0;
        int maxCount = 0;
        for(int i = 0; i<n; i++){
            if(nums[i] == 1){
                count++;
            if(count > maxCount){
                maxCount = count;
            }
        }
        else{
        // if(nums[i] != 1){
                count = 0;
            }
        }
        return maxCount;
    }
}