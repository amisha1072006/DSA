class Solution {
    public int findMaxLength(int[] nums) {
       int zeroes = 0, ones = 0;
        int res = 0;

        // diff with index
        HashMap<Integer, Integer> map = new HashMap<>();

        // ..... (diff,index) - .....(diff,index) - ans
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) zeroes++;
            else ones++;

            int diff = zeroes - ones;

            // whole array
            if(diff == 0) {
                res = Math.max(res, i + 1);
            }

            if(!map.containsKey(diff)) {
                map.put(diff, i);
            } else {
                int idx = map.get(diff);
                res = Math.max(res, i - idx);
            }
        }
        return res; 
    }
}