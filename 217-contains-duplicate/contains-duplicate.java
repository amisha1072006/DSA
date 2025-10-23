class Solution {
    public boolean containsDuplicate(int[] nums) {
    //     Arrays.sort(nums);
    //     for(int i =0;i<nums.length-1;i++){
    //             if(nums[i] == nums[i+1]){
    //             return true;
    //             }
    //     }
    //     return false;
    // }
    Set<Integer> seen = new HashSet<>();
    for(int num : nums){
        //check if the set already contains this number
        if(seen.contains(num)){
            return true;
        }
        seen.add(num);
    }
    //if the loop finishes ,no duplicates were found
    return false;
    }
}