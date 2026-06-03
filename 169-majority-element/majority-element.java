class Solution {
    public int majorityElement(int[] nums) {
       int maxCount = 0, maxAns = 0;
       for(int i = 0; i<nums.length; i++){
            int ans = 0, count = 1;
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    ans = nums[i];
                    count++;
                }
            }
                if(count > maxCount){
                    maxCount = count;
                    maxAns = nums[i];
                }
       } 
       return maxAns;
    }
}