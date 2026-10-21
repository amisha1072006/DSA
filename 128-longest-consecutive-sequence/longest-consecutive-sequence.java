class Solution {
    public int longestConsecutive(int[] nums) {
        // BRUTE FORCE APPROACH 1
        // TC = O(n^2) + O(nlogn) = O(n^2), SC = O(1)

    //     Arrays.sort(nums);
    //     int n = nums.length;
    //     int x;
    //     int cnt;
    //     int longest = 1;
    //     if(n == 0){
    //         return 0;
    //     }
    //     for(int i = 0; i<n; i++){
    //         x = nums[i];
    //         cnt = 1;
    //         for(int j = i+1; j<n; j++){
    //             if(nums[j] == x+1){
    //                 x = x+1;
    //                 cnt++;
    //             }
    //         }
    //                 if(cnt > longest){
    //                 longest = cnt;
    //             }
    //     }
    //     return longest;
    // }

        // OR
        //BRUTE FORCE APPROACH 2
        // TC = O(n^2), SC = O(1)

    //     int n = nums.length;
    //     int x;
    //     int cnt;
    //     int longest = 1;
    //     if(n == 0){
    //         return 0;
    //     }
    //     for(int i = 0; i<n; i++){
    //         x = nums[i];
    //         cnt = 1;
    //         while(linearSearch(nums, x+1) == true){
    //                 x = x+1;
    //                 cnt++;
    //             }
    //                 if(cnt > longest){
    //                 longest = cnt;
    //                  }
    //     }
    //     return longest;
    // }
    // public static boolean linearSearch(int[] arr, int x){
    //     for(int j = 0; j<arr.length; j++){
    //             if(arr[j] == x){
    //               return true;
    //             }
    //     }
    //             return false;
    //     }

      // BETTER APPROACH
      // TC = O(nlogn), SC = O(1)

      Arrays.sort(nums);
      int n = nums.length;
        if(n == 0){
            return 0;
        }
        int cnt = 1;
        int longest = 1;
        for(int i = 1; i<n; i++){
            if(nums[i] == nums[i-1]){
                continue;
            }
            else if(nums[i] == nums[i-1] +1){
              cnt++;
            }
            else{
                cnt = 1;
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
       }
    }
