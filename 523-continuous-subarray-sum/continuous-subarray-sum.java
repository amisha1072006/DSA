class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
                Map <Integer, Integer> m = new HashMap<>();
        m.put(0, -1);
        int psum = 0;
        for(int i = 0; i<nums.length; i++) {
            psum += nums[i];
            int x = ((psum % k) + k) % k;
            if(m.containsKey(x)) { 
                if(i-(m.get(x)) >= 2) {
                    return true;
                }
            } else {
                m.put(x,i);
            }
        }
        return false;
    }
}