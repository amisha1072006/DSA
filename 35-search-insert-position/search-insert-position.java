class Solution {
    public int searchInsert(int[] nums, int target) {
       int n = nums.length;
       int st = 0;
       int end = n-1;
       int ans = n;
       while(st <= end){
        int mid = st + (end - st)/ 2;
        if(nums[mid] >= target){
            ans =  mid;
            end = mid - 1;
        }
        else{
            st = mid+1;
        }
       }
       return ans;
     }
}