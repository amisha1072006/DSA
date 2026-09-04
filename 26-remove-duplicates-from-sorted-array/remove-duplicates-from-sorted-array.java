class Solution {
    public int removeDuplicates(int[] nums) {
    // BRUTE FORCE APPROACH(IF -VE NUMBERS ARE NOT GIVEN)
    // TC = O(n^2)
    // int n = nums.length;
    // for(int i = 0; i< n; i++){
    //     for(int j = 0; j<i; j++){
    //         if(nums[i] == nums[j]){
    //             nums[i] = -1;
    //             break;
    //         }
    //     }
    // }
    // int count = 0;
    // for(int i = 0; i<n; i++){
    //     if(nums[i] != -1){
    //         nums[count++] = nums[i];
    //     }
    // }
    // return count;

    // BRUTE FORCE APPROACH(IF -VE NUMBERS ARE GIVEN)
    // TC = O(n^2), SC = O(n)
    // int n = nums.length;
    // ArrayList<Integer> list = new ArrayList<>();
    // for(int i = 0; i < n; i++){
    //     boolean duplicate = false;
    //    for(int j = i+1; j < n; j++){ // or j = 0 to j< i
    //        if(nums[i] == nums[j]){
    //         duplicate = true;
    //         break;
    //        }  
    //    }
    //    if(duplicate == false){ // or if(!duplicate){
    //      list.add(nums[i]);
    //    }
    // }
    // for(int i =0; i<list.size(); i++){
    //     nums[i] = list.get(i);
    // }
    // return list.size();

   //BETTER APPROACH
   //TC = O(n), SC = O(n)
//    int n = nums.length;
//    ArrayList<Integer> list = new ArrayList<>();
//    for(int i = 0; i<n; i++){
//     if(!list.contains(nums[i])){
//         list.add(nums[i]);
//     }
//    }
//    for(int i = 0; i< list.size(); i++){
//     nums[i] = list.get(i);
//    }
//    return list.size();
 
    // OPTIMIZED APPROACH
    // TC = O(n), SC= O(1)
       int n = nums.length;
       int k =1;
       for(int i =1; i<n; i++){
        if(nums[i] != nums[i-1]){
            nums[k] = nums[i];
            k++;
        }
       }
       return k;
    }
}