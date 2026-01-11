class Solution {
    public double findMaxAverage(int[] nums, int k) {
                int n = nums.length;

        int maxWindow = 0;

        for(int i=0; i<k; i++){
            maxWindow += nums[i];
        }

        double maxAvg = (double)maxWindow / k;

        for(int i=k; i<n; i++){
            maxWindow += nums[i];
            maxWindow -= nums[i - k];

            double currentAvg = (double)maxWindow / k;

            maxAvg = Math.max(maxAvg, currentAvg);
        }return maxAvg;

    }
}