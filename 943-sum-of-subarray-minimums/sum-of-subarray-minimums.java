class Solution {
      public int sumSubarrayMins(int[] A) {
        final int MOD = (int) 1e9 + 7;
        int n = A.length;
        long res = 0;

        // Monotonic stack to find previous less and next less elements
        Stack<Pair> s = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && (i == n || A[s.peek().index] > A[i])) {
                Pair p = s.pop();
                int m = p.val;
                int j = p.index;
                int k = s.isEmpty() ? -1 : s.peek().index;
                int left = j - k;
                int right = i - j;
                res = (res + (long) m * left * right) % MOD;
            }
            if (i < n) s.push(new Pair(A[i], i));
        }

        return (int) res;
    }

    class Pair {
        int val;
        int index;
        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }  
    }
}