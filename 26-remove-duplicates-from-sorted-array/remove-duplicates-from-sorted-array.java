class Solution {
    public int removeDuplicates(int[] nums) {
       int i = 0;
        int j = 0;
        int k = 0;

        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                k++;
            }
        }
        return k + 1; 
    }
}