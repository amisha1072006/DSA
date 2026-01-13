class Solution {
    public int[] twoSum(int[] nums, int target) {
    //     int n = nums.length;
    //     for(int i = 0;i<n-1;i++){
    //         if(nums[i]+nums[i+1]==target)
    //         return new int[]{i,i+1};
    //     }
    // }return new int[]{};
    //}
    // TC - o(n){linear}
    // SC - O(1) {because we uses fixed size variables ex- n,i and at the end we are returning array in which only two elements are present}
    // but this is not correct way to  solve this problem because it only check adjacent pairs{nums = [10,2,8,5], target = 15 (this code incorrectly returns an empty array because it checks : 10+2 = 12,2+8 =10,8+5 = 13)}

    //optimal approach
    //tc-o(n)
    //sc-o(n){linear space}

    //
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
