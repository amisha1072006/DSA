class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        Set<Integer> set1 = toSet(nums1), set2 = toSet(nums2);
        int common = 0, m1 = set1.size(), m2 = set2.size(), n = nums1.length;
        for (int num : set1) {
            if (set2.contains(num)) common++;
        }
        int uniq1 = m1 - common, uniq2 = m2 - common;
        // uniq is enough in both sets;
        if (uniq1 >= n / 2 && uniq2 >= n / 2) return n;
        // uniq is not enough in either sets;
        // try to divide common in set 1 or set 2, greedy;
        if (uniq1 < n / 2 && uniq2 < n / 2) return Math.min(n, uniq1 + uniq2 + common);
        // if only set 2 has enough unique
        // put all common in set 1;
        if (uniq1 < n / 2) return Math.min(n / 2, uniq1 + common) + n/2;
        // if only set 1 has enough unique
        // put all common in set 2;
        return Math.min(n / 2, uniq2 + common) + n/2;
    }

    private Set<Integer> toSet(int[] arr) {
        Set<Integer> set = new HashSet();
        for (int num : arr) set.add(num);
        return set;
    
    }
}