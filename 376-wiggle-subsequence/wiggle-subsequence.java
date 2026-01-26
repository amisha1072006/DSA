class Solution {
    public int wiggleMaxLength(int[] nums) {
                int lastDiff = 0;
        int deleted = 0;
        for(int i = 0; i<nums.length-1;i++)
        {
            int diff = sign(nums[i+1]-nums[i]);
            if(diff==0 || diff==lastDiff)
            {
                deleted++;
                continue;
            }
            lastDiff = diff;
        }
        return nums.length - deleted;
    }
    
    private int sign(int a)
    {
        if(a==0) return 0;
        return a>0 ? 1 : -1;
    
    }
}