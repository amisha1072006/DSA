class Solution {
    public void moveZeroes(int[] nums) {
       // Brute Force Approach
       int n = nums.length;
       int temp[] = new int[n];
       int j =0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != 0){
              temp[j++] = nums[i];
            }
        }
        while(j<n){
            temp[j] = 0;
            j++;
        }
        for(int i = 0; i< temp.length; i++){
            nums[i] = temp[i];
        }
    }
}