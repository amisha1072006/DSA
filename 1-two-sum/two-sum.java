class Solution {
    public int[] twoSum(int[] nums, int target) {
    // Brute force Approach
    // TC = O(n^2), SC = O(1) 

//     for(int i = 0; i<nums.length; i++){
//         for(int j = i+1; j< nums.length; j++){
//             if(nums[i] + nums[j] == target){
//                 return new int[] {i,j};
//             }
//         }
//     }
//     return new int[] {};
//     }
// }

    //better approach if given array is already sorted otherwise this is the optimal approach
    //tc-o(n)
    // NOTE : in worst case hashmap can take o(n) when hash collisions occurs , in that case tc = o(n^2). we can also use TreeMap for better time complexity because in both average and worst case it will take logn time complexity
    //sc-o(n){linear space}

    Map<Integer , Integer> numMap = new TreeMap<Integer,Integer>();
    int n = nums.length;
    for(int i = 0; i< n; i++){
        int compliment = target - nums[i];
        if(numMap.containsKey(compliment)){
            return new int[] {numMap.get(compliment),i};
        }
        numMap.put(nums[i],i);
    }
    return new int[] {};

   //OPTIMAL APPROACH 
   // NOTE: its only work when problem only say to return that the sum of two elements equal to target then return true otherwise return false. if problem say for returning the index then we have to use extra space for storing oiginal index because after sorting the original index of elements will change but if given array is already sorted then we can easily return index with this approach and that will be optimal approach
   //TC = O(nlogn), SC = O(1)

//    Arrays.sort(nums);
//    int n = nums.length;
//    int i = 0; 
//    int j = n-1;
//    while(i<j){
//     if(nums[i] + nums[j] == target){
//         return true;
//     }
//     else if(nums[i] + nums[j] < target){
//         i++;
//     }
//     else{
//         j--;
//     }
//    }
//    return false;

    }
}

