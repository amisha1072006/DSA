class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
                int n = A.length;
        if (n == 0) {
            return 0;
        }
        if (L + M > n) {
            throw new IllegalArgumentException();
        }
        
        int[] Ls = new int[n];
        int[] Ms = new int[n];
        
        int lSum = 0;
        int mSum = 0;
        
        for (int i = 0; i <= n - L; i++) {
            if (i == 0) {
                for (int j = 0; j < L; j++) {
                    lSum += A[j];
                }
            } else {
                lSum = lSum - A[i-1] + A[i+L-1];
            }
            
            Ls[i] = lSum;
        }
        
        for (int i = 0; i <= n - M; i++) {
            if (i == 0) {
                for (int j = 0; j < M; j++) {
                    mSum += A[j];
                }
            } else {
                mSum = mSum - A[i-1] + A[i+M-1];
            }
            
            Ms[i] = mSum;
        }
        
        int[] lmax = new int[n+1];
        int[] mmax = new int[n+1];
        
        for (int i = n - 1; i >= 0; i--) {
            lmax[i] = Math.max(lmax[i+1], Ls[i]);
            mmax[i] = Math.max(mmax[i+1], Ms[i]);
        }

        int ans = 0;
        for (int i = 0; i <= n - L - 1; i++) {
            ans = Math.max(ans, Ls[i] + mmax[i+L]);
        }
        for (int i = 0; i <= n - M - 1; i++) {
            ans = Math.max(ans, Ms[i] + lmax[i+M]);
        }

        return ans;
    
    }
}