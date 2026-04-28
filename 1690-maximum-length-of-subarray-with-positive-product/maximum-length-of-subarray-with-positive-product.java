class Solution {
    public int getMaxLen(int[] nums) {
                int posLen = 0; // positive length
        int negLen = 0; // negetive length
        int res = 0;
        for (int num : nums) {
            if (num == 0) {
                posLen = 0;
                negLen = 0;
            } else if (num > 0) {
                posLen++;
                negLen = negLen == 0 ? 0 : negLen+1;
            } else {
                int temp = posLen;
                posLen = negLen == 0 ? 0 : negLen + 1;
                negLen = temp + 1;
            }
            res = Math.max(res, posLen);
        }
        return res;

    }
}