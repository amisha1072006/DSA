class Solution {
    public void moveZeroes(int[] nums) {
       // Brute Force Approach
    //    int n = nums.length;
    //    int temp[] = new int[n];
    //    int j =0;
    //     for(int i = 0; i<nums.length; i++){
    //         if(nums[i] != 0){
    //           temp[j++] = nums[i];
    //         }
    //     }
    //     while(j<n){
    //         temp[j] = 0;
    //         j++;
    //     }
    //     for(int i = 0; i< temp.length; i++){
    //         nums[i] = temp[i];
    //     }

    // optmize approach

     int j = -1;
     for(int i = 0; i<nums.length; i++){
        if(nums[i] ==0){
            j =i;
            break;
        }
     }
     if(j == -1){
        return;
     }
     
     for(int k = j+1; k<nums.length; k++){
        if(nums[k] != 0){
            swap(nums, k, j);
            j++;
        }
     }
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
     }
}