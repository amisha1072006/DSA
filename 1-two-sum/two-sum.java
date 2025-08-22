class Solution {
    public int[] twoSum(int[] nums, int target) {
//         int[] ans = {-1};
//         for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 if(nums[i]+nums[j]==target){
//                  ans = new int[]{i,j};
//                  return ans;
//             }
//         }
//     }
//     return ans;
// }
int n = nums.length;
int[] ans={-1};
//value,index
HashMap<Integer,Integer> mp = new HashMap<>();
for(int i = 0;i<n;i++){
    int partner = target-nums[i];
    if(mp.containsKey(partner)){
        ans = new int[]{i,mp.get(partner)};
        return ans;
    }
    mp.put(nums[i],i);
}
return ans;
}
}