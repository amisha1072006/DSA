class Solution {
    public int subarraySum(int[] nums, int k) {

        // BRUTE FORCE APPROACH
        // TC = O(n^2), SC = O(1)

    //   int n = nums.length;
    //   int sum = 0;
    //   int count = 0;
    //   for(int i = 0; i<n; i++){
    //       sum = nums[i];
    //       if(sum == k){
    //         count++;
    //       }
    //     for(int j = i+1; j<n; j++){
    //         sum += nums[j];
    //         if(sum == k){
    //             count++;
    //         }
    //     }
    //   }
    //   return count;

    // BETTER APPROACH
    // TC = O(), SC = O()

//     int sum = nums[0];
//     int n = nums.length;
//     int count = 0;
//     int left = 0;
//     int right = 0;
//     while(right <n){
//         while(left < right && sum > k){
//             sum -= nums[left];
//             left++;
//         }
//         if(sum == k){
//             count++;
//         }
//         right++;
//         if(right < n){
//             sum += nums[right];
//         }
//     }
//     return count;
//     }
// }


int n = nums.length;
int sum = 0;
int count = 0;
Map<Integer, Integer> map = new HashMap<>();
map.put(0,1);
for(int i = 0; i<n; i++){
    sum += nums[i];
    int rem = sum - k;
    if(map.containsKey(rem)){
        count += map.get(rem);
    }
    if(!map.containsKey(sum)){
        map.put(sum,1);
    }
    else{
    map.put(sum, map.get(sum) + 1);
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