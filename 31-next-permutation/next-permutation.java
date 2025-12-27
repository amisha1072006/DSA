class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            } 
        }

        if(index==-1){
             revArray(nums, index);
             return;
        }

        for (int j = n-1; j > index; j--) {
            if (nums[j] > nums[index]) {
                int temp = nums[index];
                nums[index] = nums[j];
                nums[j] = temp;
                break;
            }
        }
        revArray(nums, index);
    }

    public int[] revArray(int[] nums, int i) {
        int n = nums.length - 1;
        i = i + 1;
        while (i < n) {
            int temp = nums[i];
            nums[i] = nums[n];
            nums[n] = temp;
            i++;
            n--;
        }
        return nums;

    }
}