class Solution {
    public int subarraySum(int[] nums, int k) {
      int n = nums.length;
      int sum = 0;
      int count = 0;
      for(int i = 0; i<n; i++){
          sum = nums[i];
          if(sum == k){
            count++;
          }
        for(int j = i+1; j<n; j++){
            sum += nums[j];
            if(sum == k){
                count++;
            }
        }
      }
      return count;
    }
}








//         HashMap<Integer, Integer> hm = new HashMap<>();
        
//         int prefixSum = 0; // Actual Sum upto the Index
        
//         // If prefixSum - k = 0, it means the subarray starts from index 0.
//         // We add (0, 1) to handle this case naturally.
//         hm.put(0, 1); 

//         int noOfSubArrayPossible = 0;

//         for (int i = 0; i < nums.length; i++) {
//             prefixSum += nums[i];               // Accumulate sum
            
//             int remove = prefixSum - k;         // Calculate what previous sum we need to chop off
            
//             // If HashMap contains the exact prefixSum to remove, it means we found valid subarrays
//             if(hm.containsKey(remove)){         
//                 noOfSubArrayPossible += hm.get(remove);
//             }
            
//             // Store/Update the current prefixSum frequency in the map
//             hm.put(prefixSum, hm.getOrDefault(prefixSum, 0) + 1); 
//         }
//         return noOfSubArrayPossible;
    
//     }
// }