class Solution {
    public int[] twoSum(int[] nums, int target) {
    //     int n = nums.length;
    //     for(int i = 0;i<n-1;i++){
    //         if(nums[i]+nums[i+1]==target)
    //         return new int[]{i,i+1};
    //     }
    // }return new int[]{};
    Map<Integer , Integer> numMap = new HashMap<Integer,Integer>();
    int n = nums.length;
    for(int i = 0; i< n; i++){
        int compliment = target - nums[i];
        if(numMap.containsKey(compliment)){
            return new int[] {numMap.get(compliment),i};
        }
        numMap.put(nums[i],i);
    }
    return new int[] {};
    }
}
