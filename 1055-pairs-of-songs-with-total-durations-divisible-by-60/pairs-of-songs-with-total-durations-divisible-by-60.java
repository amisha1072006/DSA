class Solution {
    public int numPairsDivisibleBy60(int[] time) {
                long cnt=0;
        int fre[]=new int[60];
        for(int x:time) fre[x%60]++;
        cnt += (long)fre[30] * (fre[30] - 1) / 2;
        cnt += (long)fre[0] * (fre[0] - 1) / 2;
        for (int i = 1; i < 30; i++) {
            cnt += (long)fre[i] * fre[60 - i];
        }
        return (int)cnt;
    
    }
}