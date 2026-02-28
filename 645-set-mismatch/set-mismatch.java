class Solution {
    public int[] findErrorNums(int[] nums) {
       int n=nums.length;
        //Initialize the frequency array in n+1 to start with the right index
        int[] frequency = new int[n+1];
        int missing=0;
        int repeated=0;

        //The frequency[] array will count each number that appears inside nums[] array
        for(int i=0; i<n; i++){
            frequency[nums[i]]++;
        }

        //We find both, the repeated number and the missing number based on the previous count.
        for(int i=1; i<=n; i++){
            if(frequency[i]==2){
                repeated = i;
            }
            if(frequency[i]==0){
                missing = i;
            }
        }

        int[] ans = {repeated,missing};
        return ans; 
    }
}