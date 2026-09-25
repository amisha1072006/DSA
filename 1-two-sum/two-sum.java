class Solution {
    public int[] twoSum(int[] nums, int target) {
    // Brute force Approach
    // TC = O(n^2), SC = O(1) 

    for(int i = 0; i<nums.length; i++){
        for(int j = i+1; j< nums.length; j++){
            if(nums[i] + nums[j] == target){
                return new int[] {i,j};
            }
        }
    }
    return new int[] {};
    }
}

    //optimal approach
    //tc-o(n)
    //sc-o(n){linear space}

//     Map<Integer , Integer> numMap = new HashMap<Integer,Integer>();
//     int n = nums.length;
//     for(int i = 0; i< n; i++){
//         int compliment = target - nums[i];
//         if(numMap.containsKey(compliment)){
//             return new int[] {numMap.get(compliment),i};
//         }
//         numMap.put(nums[i],i);
//     }
//     return new int[] {};
//     }
// }
