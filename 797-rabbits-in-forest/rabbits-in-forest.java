class Solution {
    public int numRabbits(int[] answers) {
        int[] cnt = new int[1001];
        for (int x : answers) cnt[x]++;
        
        int ans = 0;
        for (int i = 0; i <= 1000; i++) if (cnt[i] > 0) {
            int groupSize = i + 1;
            int groups = (cnt[i] + groupSize - 1) / groupSize;
            ans += groups * groupSize;
        }
        return ans;
    }
}