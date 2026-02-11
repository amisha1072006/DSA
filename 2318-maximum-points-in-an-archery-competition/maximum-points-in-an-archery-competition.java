class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] result = new int[12];
        int[] bobtemp = new int[12];
        int[] max = new int[]{Integer.MIN_VALUE};
        helper(numArrows, aliceArrows, bobtemp, result, 11, 0, max);
        return result;
    }
    private void helper(int numArrows, int[] aliceArrows, int[] bobtemp, int[] result, int index, int bobpoints, int[] max){
        if(index < 0 || numArrows <= 0){
            if(numArrows > 0){
                bobtemp[0] += numArrows;
            }
            if(bobpoints > max[0]){
                max[0] = bobpoints;
                for(int i = 0; i < 12; i++){
                    result[i] = bobtemp[i];
                }
            }
            return;
        }
        if(numArrows >= (aliceArrows[index] + 1)){
            bobtemp[index] = aliceArrows[index] + 1;
            helper(numArrows - (aliceArrows[index] + 1), aliceArrows, bobtemp, result, index - 1, bobpoints + index, max);
            bobtemp[index] = 0;
        }
        helper(numArrows, aliceArrows, bobtemp, result, index - 1, bobpoints, max);
        bobtemp[index] = 0;
    
    }
}