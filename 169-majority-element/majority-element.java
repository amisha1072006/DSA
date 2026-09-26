import java.util.*;
class Solution {
    public int majorityElement(int[] nums) {
        // BRUTE FORCE APPROACH

    //    int maxCount = 0, ans = 0;
    //    for(int i = 0; i<nums.length; i++){
    //         int count = 1;
    //         for(int j = i+1; j<nums.length; j++){
    //             if(nums[i] == nums[j]){
    //                 count++;
    //             }
    //         }
    //         if(count > maxCount){
    //                 maxCount = count;
    //                 ans = nums[i];
    //         }
    //    } 
    //    return ans;

    // OPTMIZED APPROACH

    Arrays.sort(nums);
   // HashSet<Integer> processed = new HashSet<>();
    int n = nums.length;
    int count = 1;
    int maxCount = 1, ans = nums[0];
            if(n == 1){
          return nums[0];
        }
    for(int i = 0; i<nums.length-1; i++){

         if(nums[i] == nums[i+1]){
            count++;
         }
         else {
            count = 1;
         }
         if(count > maxCount){
            maxCount = count;
            ans = nums[i+1];
         }
      }
    return ans;
}
}