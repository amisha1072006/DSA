import java.util.*;
class Solution {
    public int majorityElement(int[] nums) {
        // BRUTE FORCE APPROACH

    //    int maxCount = 0, ans = 0;
    //    for(int i = 0; i<nums.length; i++){
    //         int count = 1;
    //         for(int j = i+1; j<nums.length; j++){
    //             if(nums[i] == nums[j]){
    //                 count++;
    //             }
    //         }
    //         if(count > maxCount){
    //                 maxCount = count;
    //                 ans = nums[i];
    //         }
    //    } 
    //    return ans;

    // OPTMIZED APPROACH

    Arrays.sort(nums);
    HashSet<Integer> processed = new HashSet<>();
    int n = nums.length;
    for(int i = 0; i<nums.length; i++){
        int currentElement = nums[i];
        if(!processed.contains(currentElement)){
            if(i + n / 2 < n && nums[i+ n / 2] == currentElement){
                return currentElement;
            }
            processed.add(currentElement);
        } 
    }
    return -1;
}
}