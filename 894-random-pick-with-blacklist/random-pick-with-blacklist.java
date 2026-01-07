class Solution {
List<int[]> intervals;
    int[] a;

    public Solution(int n, int[] blacklist) {
                Arrays.sort(blacklist);
        int min = 0, max = n - 1;
        intervals = new ArrayList<>();
        for (int i: blacklist) {
            if (i - min > 0) {
                intervals.add(new int[] {min, i - 1});
                max = i - 1;
            }
            
            min = i + 1;
        }
        
        if (min < n) {
            intervals.add(new int[] {min, n - 1});
            max = n - 1;
        }
        
        a = new int[intervals.size()];
        a[0] = intervals.get(0)[1] - intervals.get(0)[0] + 1;
        for (int i = 1; i < a.length; ++i) {
            a[i] = intervals.get(i)[1] - intervals.get(i)[0] + 1 + a[i - 1];
        }
    
    }
    
    public int pick() {
        int n = (int)(Math.random() * a[a.length - 1]);
        int l = 0, r = a.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (n < a[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        int[] interval = intervals.get(l);
        return (int)(Math.random() * (interval[1] - interval[0] + 1) + interval[0]);
    
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */