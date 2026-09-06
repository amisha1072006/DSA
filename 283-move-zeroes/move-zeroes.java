// class Solution {
//     public void moveZeroes(int[] nums) {
      // Brute Force Approach
       //TC = O(n), SC = O(n)
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

    // optimize approach
    // TC = O(n), SC = O(1)
    class Solution {
    public void moveZeroes(int[] nums) {
     int j = -1;
     for(int i = 0; i<nums.length; i++){
        if(nums[i] ==0 && j == -1){
            j =i;
        }
        if(nums[i] != 0 && j != -1){
            swap(nums, i, j);
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
