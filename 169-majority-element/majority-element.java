import java.util.*;
class Solution {
    public int majorityElement(int[] nums) {
        // BRUTE FORCE APPROACH

    //     ans = 0;
    //int n = nums.length;
    //    for(int i = 0; i<nums.length; i++){
    //         int count = 1;
    //         for(int j = i+1; j<nums.length; j++){
    //             if(nums[i] == nums[j]){
    //                 count++;
    //             }
    //         }
    //         if(count >  maxCount){
    //                 maxCount = count;
    //                 ans = nums[i];
    //         }

     //OR
     //if(count > n/2){
     // return nums[i];
     //}

    //    } 
    //    return ans;

    // BETTER APPROACH
    //TC = O(nlogn), SC = O(1)

//     Arrays.sort(nums);
//     int n = nums.length;
//     int count = 1;
//     int maxCount = 1, ans = nums[0];
//         if(n == 1){
//           return nums[0];
//         }
//     for(int i = 0; i<nums.length-1; i++){

//          if(nums[i] == nums[i+1]){
//             count++;
//          }
//          else {
//             count = 1;
//          }
//          if(count > n/2){
//             return nums[i+1];
//          }
//       }
//     return -1;
// }
// }

//OPTIMIZED APPROACH
// TC = O(n), SC = O(1)

int n = nums.length;
int count = 0;
int el = 0;
for(int i = 0; i<n; i++){
  if(count == 0){
    count = 1;
    el = nums[i];
  }
  else if(nums[i] == el){
    count++;
  }
  else{
    count--;
  }
}
  int count1 = 0;
  for(int i = 0; i<n; i++){
    if(nums[i] == el){
        count1++;
    }
  }
  if(count1 > n/2){
    return el;
  }
  return -1;
}
    }