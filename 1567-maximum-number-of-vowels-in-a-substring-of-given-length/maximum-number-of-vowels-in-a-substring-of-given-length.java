class Solution {
    public int maxVowels(String s, int k) {
        int[] chars = new int[128];
        chars['a']++;
        chars['e']++;
        chars['i']++;
        chars['o']++;
        chars['u']++;
        char[] arr = s.toCharArray();
        int current = 0;
        for (int i = 0; i < k; i++) {
            current += chars[arr[i]];
        }
        int max = current;
        for (int i = 0, j = k; j < arr.length; i++, j++) {
            current -= chars[arr[i]];
            current += chars[arr[j]];
            max = Math.max(max, current);
        }
        return max;
    
    }
}