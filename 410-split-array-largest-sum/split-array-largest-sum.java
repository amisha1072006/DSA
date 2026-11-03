class Solution {
    public int splitArray(int[] nums, int k) {
//         int n = nums.length;
//         int maxElement = nums[0];
//         int sum = nums[0];
//         for(int i = 1; i<n; i++){
//             if(nums[i] > maxElement){
//                 maxElement = nums[i];
//             }
//             sum += nums[i];
//         }
//         for(int minLargestSum = maxElement; minLargestSum <= sum; minLargestSum++){
//             if(func(nums, minLargestSum, k) == true){
//                 return minLargestSum;
//             }
//         }  
//         return -1;
//     }
//     public static boolean func(int[] nums, int minLargestSum, int k){
//         int sum = 0;
//         int cnt = 0;
//         for(int i = 0; i<nums.length; i++){
//              sum += nums[i];
//              if(sum > minLargestSum){
//                 cnt++;
//                 sum = nums[i];
//              }
//         }
//         if(sum > 0){
//             cnt++;
//         }
//         if(cnt <= k){
//             return true;
//         }
//         return false;
//     }
// }

int n = nums.length;
        int maxElement = nums[0];
        int sum = nums[0];
        for(int i = 1; i<n; i++){
            if(nums[i] > maxElement){
                maxElement = nums[i];
            }
            sum += nums[i];
        }
        int left = maxElement;
        int right = sum;
        int ans = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(func(nums, mid, k) == true){
                // ans =  mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }  
        return left;
    }
    public static boolean func(int[] nums, int minLargestSum, int k){
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i<nums.length; i++){
             sum += nums[i];
             if(sum > minLargestSum){
                cnt++;
                sum = nums[i];
             }
        }
        if(sum > 0){
            cnt++;
        }
        if(cnt <= k){
            return true;
        }
        return false;
    }
}