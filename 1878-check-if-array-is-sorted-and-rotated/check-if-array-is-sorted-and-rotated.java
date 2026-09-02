class Solution {
    public boolean check(int[] nums) {
        //BRUTE FORCE APPROACH
        // TC = O(n^2), SC = o(n)
        // int n = nums.length;
        // int arr[] = new int[nums.length];
        // for(int r=0; r<=n; r++){
        //     int idx = 0;
        //     for(int i=r; i<n; i++){
        //         arr[idx] = nums[i];
        //         idx++;
        //     }
        //     for(int i = 0; i<r; i++){
        //         arr[idx] = nums[i];
        //         idx++;
        //     }
        //     // is the array sorted
        //     boolean isSort = true;
        //     for(int i = 0; i<n-1; i++){
        //         if(arr[i] > arr[i+1]){
        //            isSort = false;
        //            break;
        //         }
        //     }
        //     if(isSort == true){
        //         return true;
        //     }
        // }
        // return false;

        // Better Approach
        // TC = O(n^2), SC = O(n)
       int n = nums.length;
       int arr[] = Arrays.copyOf(nums, n);
       Arrays.sort(arr);
       for(int r=0; r<n; r++){
        boolean isSorted = true;
        for(int i=0; i<n; i++){
          if(arr[i] != nums[(i+r)%n]){
            isSorted = false;
            break;
          }
        }
        if(isSorted){
            return true;
        }
       }
        return false;
    }
}