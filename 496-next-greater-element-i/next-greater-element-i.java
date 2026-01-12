class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
               int l1 = nums1.length;
        int l2 = nums2.length;
        int[] ans = new int[l1];
        for (int i = 0; i < l1; i++) {
            int j = 0;
            while (j < l2 && nums2[j] != nums1[i]) {
                j++;
            }
            int nextGreater = -1;
            for (int k = j + 1; k < l2; k++) {
                if (nums2[k] > nums1[i]) {
                    nextGreater = nums2[k];
                    break;
                }
            }
            ans[i] = nextGreater;
        }
        return ans;
 
    }
}