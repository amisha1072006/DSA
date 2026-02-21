class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
             if(nums.length <= 2)
            return 0;
        int l = 0, r = 1, prev = nums[1] - nums[0];
        int cnt = 0;
        for(r = 2; r < nums.length; r++){
            if(nums[r] - nums[r-1] != prev){
                prev = nums[r] - nums[r-1];
                if(r - l >= 3){
                    cnt += ((r-l-1)*(r-l-2))/2;
                }
                l = r - 1;
            }
        }
        if(r - l >= 3){
            cnt += ((r-l-1)*(r-l-2))/2;
        }
        return cnt;
       
    }
}