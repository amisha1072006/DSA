class Solution {
    public int longestSubarray(int[] nums) {
        List<Integer> zeros = new ArrayList<>();

        for(int i = 0; i<nums.length; i++){
            if(nums[i]==0) zeros.add(i);
        }

        if(zeros.size()==0 || zeros.size()==1) return nums.length-1;
        if(zeros.size()==nums.length) return 0;

        zeros.addFirst(-1);
        zeros.add(nums.length);

        int longest = 0;
        for(int i = 1; i<zeros.size()-1; i++){
            longest = Math.max(longest, zeros.get(i+1) - zeros.get(i-1) - 2);
        }

        return longest;
    
    }
}