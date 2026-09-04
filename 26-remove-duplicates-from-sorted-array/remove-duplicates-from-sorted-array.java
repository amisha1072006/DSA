class Solution {
    public int removeDuplicates(int[] nums) {
    // BRUTE FORCE APPROACH
    // TC = O(n^2), SC = O(n)
    int n = nums.length;
    ArrayList<Integer> list = new ArrayList<>();
    for(int i = 0; i < n; i++){
        boolean duplicate = false;
       for(int j = 0; j < i; j++){
           if(nums[i] == nums[j]){
            duplicate = true;
            break;
           }  
       }
       if(duplicate == false){
         list.add(nums[i]);
       }
    }
    for(int i =0; i<list.size(); i++){
        nums[i] = list.get(i);
    }
    return list.size();


    //    int i = 0;
    //     int j = 0;
    //     int k = 0;

    //     while (j < nums.length) {
    //         if (nums[i] == nums[j]) {
    //             j++;
    //         } else {
    //             i++;
    //             nums[i] = nums[j];
    //             k++;
    //         }
    //     }
    //     return k + 1; 
    }
}