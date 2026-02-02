class Solution {
    public long wonderfulSubstrings(String word) {
                long[] cnt = new long[1024]; // cnt[state] stores how many times the state occurs
        cnt[0] = 1; // empty string gives case where all characters occur even number of times
        int mask = 0; // current state
        long ans = 0;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            int idx = c - 'a';
            mask ^= 1 << idx; // update state
            ans += cnt[mask]; // add count of same previous states
            for (int i = 1; i <= 512; i*=2) {
                ans += cnt[mask ^ i];
            }
            cnt[mask]++; // add 1 to count of times we've seen current state
        }
        return ans;
   
    }
}