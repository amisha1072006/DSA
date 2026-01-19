class Solution {
    public int maxScore(int[] cardPoints, int k) {
                int totalSum = 0;
        int left = 0;
        int sum = 0;
        int minValue = Integer.MAX_VALUE;
        int length = cardPoints.length - k;
        for(int right=0;right<cardPoints.length;right++){
            if(right-left+1 > length){
                sum -= cardPoints[left];
                left++;
            }
            sum += cardPoints[right];
            totalSum += cardPoints[right];
            if(right-left+1 == length) minValue = Math.min(minValue, sum);
        }
    return totalSum - minValue;
    
    }
}