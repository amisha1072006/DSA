class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int arr[] = new int[nums.length];
        for(int r=0; r<=n; r++){
            int idx = 0;
            for(int i=r; i<n; i++){
                arr[idx] = nums[i];
                idx++;
            }
            for(int i = 0; i<r; i++){
                arr[idx] = nums[i];
                idx++;
            }
            // is the array sorted
            boolean isSort = true;
            for(int i = 0; i<n-1; i++){
                if(arr[i] > arr[i+1]){
                   isSort = false;
                   break;
                }
            }
            if(isSort == true){
                return true;
            }
        }
        return false;
    }
}