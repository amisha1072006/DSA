class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
  
    // BRUTE FORCE APPROACH
    //TC = O(n^3 * log(no.of unique)), SC = 2*O(no. of triplets)

    //   int n = nums.length;
    //   List<List<Integer>> ans = new ArrayList<>();
    //   Set<List<Integer>> ans1 =  new HashSet<>();
    //   for(int i = 0; i<n; i++){
    //     for(int j = i+1; j<n; j++){
    //         for(int k = j+1; k<n; k++){
    //             if(i != j && i !=k && j != k){
    //             if(nums[i]+nums[j]+nums[k] == 0){
    //                 List<Integer> list = new ArrayList<>();
    //                 list.add(nums[i]);
    //                 list.add(nums[j]);
    //                 list.add(nums[k]);
    //                 Collections.sort(list);
    //                 ans1.add(list);
    //             }
    //         }    
    //         }
    //     }
    //   }
    //   ans.addAll(ans1);
    //   return ans;

    // BETTER APPROACH 
    // TC = O(), SC = O()

    int n = nums.length;
    List<List<Integer>> ans = new ArrayList<>();
    Set<List<Integer>> ans1 =  new HashSet<>();
    for(int i = 0; i<n; i++){
        Set<Integer> hashset = new HashSet<>();
       for(int j = i+1; j<n; j++){
           int third = -(nums[i] + nums[j]);
           if(hashset.contains(third)){
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            list.add(nums[j]);
            list.add(third);
            Collections.sort(list);
            ans1.add(list);
           }
           hashset.add(nums[j]);
       }
    }
    ans.addAll(ans1);
    return ans;
    }
}