class Solution {
    public int[] rearrangeArray(int[] nums) {

        // BRUTE FORCE APPROACH
        //TC = O(4n), SC = O(n)

//         int n = nums.length;
//         int temp[] = new int[n];
//         int k = 0;
//         for(int i = 0; i<n; i++){
//             if(nums[i] > 0){
//                 temp[k++] = nums[i];
//             }
//         }
//         for(int i = 0; i<n; i++){
//             if(nums[i] < 0){
//                 temp[k++] = nums[i]; 
//             }
//         }
//         k = 0;
//         for(int i = 0; i<n; i = i+2){
//             nums[i] = temp[k++];
//         }
//         for(int i = 1; i<n; i = i+2){
//             nums[i] = temp[k++];
//         }
//     return nums;
//     }
// }

     // OPTIMAL APPROACH
     // TC = O(n), SC = O(n)

        int n = nums.length;
        int temp[] = new int[n];
        int posIdx = 0;
        int negIdx = 1;
        for(int i = 0; i<n; i++){
            if(nums[i] >0){
                temp[posIdx] = nums[i];
                posIdx += 2;
            }
            else{
                temp[negIdx] = nums[i];
                negIdx += 2;
            }
        }
        return temp;
    }
}