class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int temp[] = new int[n];
        int k = 0;
        for(int i = 0; i<n; i++){
            if(nums[i] > 0){
                temp[k++] = nums[i];
            }
        }
        for(int i = 0; i<n; i++){
            if(nums[i] < 0){
                temp[k++] = nums[i]; 
            }
        }
        k = 0;
        for(int i = 0; i<n; i = i+2){
            nums[i] = temp[k++];
        }
        for(int i = 1; i<n; i = i+2){
            nums[i] = temp[k++];
        }
    return nums;
    }
}