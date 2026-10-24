class Solution {
    public int[] searchRange(int[] nums, int target) {
 
        // BRUTE FORCE APPROACH
        // TC = O(n), SC= O(1)

//         int n = nums.length;
//         int[] ans = new int[2];
//         if(n == 0){
//            ans[0] = -1;
//            ans[1] = -1;
//            return ans;
//         }
//         for(int i =0; i<n; i++){
//             if(nums[i] == target){
//             if(i == 0 || nums[i-1] != target){
//              ans[0] = i;
//             }
//            }
//            if(nums[i] == target){
//             ans[1] =  i;
//            }
//         }
//         if(ans[0] == 0){
//           ans[0] = -1;
//        }
//        if(ans[1] == 0){
//           ans[1] = -1;
//        }
//        return ans;
//     }
// }

       // OPTIMAL APPROACH
       // TC = O(logn), SC= O(1)

        int n = nums.length;
        int ans[] = new int[2];
        int st = 0;
        int end = n-1;
        if(n == 0){
           ans[0] = -1;
           ans[1] = -1;
           return ans;
        }
        ans[0] = -1;
       while(st <= end){
        int mid = st + (end - st)/ 2;
        if(nums[mid] == target){
            ans[0] = mid;
            end = mid -1;
       }
       else if(nums[mid] < target){
           st = mid +1;
       }
       else{
           end = mid-1;
        }
       }
       st = 0;
       end = n-1;
       ans[1] = -1;
       while(st <= end){
        int mid = st + (end - st)/ 2;
        if(nums[mid] == target){
            ans[1] = mid;
            st = mid + 1;
       }
       else if(nums[mid] < target){
        st = mid+1;
       }
       else{
          end = mid - 1;
        }
       }
       return ans;
    }
}