class Solution {
        private int[] merge(int[] a, int[] b) {
        int[] m = new int[a.length + b.length];
        int i = 0, j = 0, d = 0;

        while (i < a.length || j < b.length) {
            if (j == b.length || (i < a.length && a[i] < b[j])) {
                m[d++] = a[i++];
            } else {
                m[d++] = b[j++];
            }
        }
        return m;
    }


    public int[] sortArray(int[] nums) {
              if (nums.length <= 20) {
            return insertionSort(nums);
        }

        int mid = nums.length / 2;

        int[] left = new int[mid];
        int[] right = new int[nums.length - mid];

        System.arraycopy(nums, 0, left, 0, mid);
        System.arraycopy(nums, mid, right, 0, nums.length - mid);

        return merge(sortArray(left), sortArray(right));
    }

    // Insertion Sort for small arrays
    private int[] insertionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j > 0 && nums[j] < nums[j - 1]) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                j--;
            }
        }
        return nums;
  
    }
}