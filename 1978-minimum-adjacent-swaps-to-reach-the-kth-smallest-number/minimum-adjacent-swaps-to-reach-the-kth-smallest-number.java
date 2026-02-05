class Solution {
        public void swap(StringBuilder nums, int idx1, int idx2) {
        char ch = nums.charAt(idx1);
        nums.setCharAt(idx1, nums.charAt(idx2));
        nums.setCharAt(idx2, ch);
    }

    public void reverse(StringBuilder nums, int start, int end) {
        int left = start;
        int right = end;
        while (right > left) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public void nextGreater(StringBuilder nums) {
        int n = nums.length();
        int i = n - 2;
        while (i >= 0 && nums.charAt(i) >= nums.charAt(i + 1)) {
            i--;
        }
        if (i >= 0) {
            int j = n - 1;
            while (nums.charAt(j) <= nums.charAt(i)) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);
    }

    public int getMinSwaps(String num, int k) {
        StringBuilder nums = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            nextGreater(nums);
        }
        String str = nums.toString(); 
        char[] arr1 = num.toCharArray();
        char[] arr2 = str.toCharArray();
        int n = arr1.length;
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (arr1[i] != arr2[i]) {
                int j = i;
                while (arr1[j] != arr2[i]) {
                    j++;
                }
                while (j > i) {
                    char temp = arr1[j];
                    arr1[j] = arr1[j - 1];
                    arr1[j - 1] = temp;
                    swaps++;
                    j--;
                }
            }
        }

        return swaps;
    
    }
}