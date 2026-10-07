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
    // TC = O(n^2 * log(m))where m is a variable = O(n^2), SC = O(n) + O(no. of unique triplets)

    // int n = nums.length;
    // List<List<Integer>> ans = new ArrayList<>();
    // Set<List<Integer>> ans1 =  new HashSet<>();
    // for(int i = 0; i<n; i++){
    //     Set<Integer> hashset = new HashSet<>();
    //    for(int j = i+1; j<n; j++){
    //        int third = -(nums[i] + nums[j]);
    //        if(hashset.contains(third)){
    //         List<Integer> list = new ArrayList<>();
    //         list.add(nums[i]);
    //         list.add(nums[j]);
    //         list.add(third);
    //         Collections.sort(list);
    //         ans1.add(list);
    //        }
    //        hashset.add(nums[j]);
    //    }
    // }
    // ans.addAll(ans1);
    // return ans;

    // OPTIMAL APPROACH
    // TC = O(nlogn) + O(n *n) = O(n^2), SC = O(no. of unique triplets)
 
   List<List<Integer>> ans = new ArrayList<>();
   Arrays.sort(nums);
   int n = nums.length;
   for(int i = 0; i<n; i++){
       if(i >0 && nums[i] == nums[i-1]) continue;
       int j = i+1;
       int k = n-1;
       while(j<k){
        int sum = nums[i] + nums[j] + nums[k];
        if(sum<0){
            j++;
        }
        else if(sum >0) {
           k--;
        }
        else{
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            list.add(nums[j]);
            list.add(nums[k]);
            ans.add(list);
            j++;
            k--;
            while(j < k && nums[j] == nums[j-1]) j++;
            while(j<k && nums[k] == nums[k+1]) k--;
        }
       }
   }
   return ans;
    }
}