class Solution {
    public void nextPermutation(int[] nums) {

        // BRUTE FORCE APPROACH
        // TC = O(n*n!), SC = O(n*n!)
        // Don't need to write this brute force approach in interview because it will take lot of time just only tell it from a very high level that generate all permutation, linear search, next will be my answer after that tell him that this is going to take a time complexity of a very high order that is why i try to optimize it
//         int n = nums.length;
//         int[] temp = Arrays.copyOf(nums, n);
//         Arrays.sort(temp);
//         List<Integer> list = new ArrayList<>();
//         for(int i = 0; i<n; i++){
//             list.add(temp[i]);
//         }
//         List<List<Integer>> ans = new ArrayList<>();
//         getPers(list, 0, ans);
//         ans.sort((a,b) -> {
//             for(int i = 0; i< a.size(); i++){
//                 if(!a.get(i).equals(b.get(i))){
//                     return Integer.compare(a.get(i), b.get(i));
//                 }
//             }
//             return 0;
//         });
//         List<Integer> current = new ArrayList<>();
//         for(int num: nums){
//             current.add(num);
//         }
//         int index = -1;
//         for(int i = 0; i<ans.size(); i++){
//             if(ans.get(i).equals(current)){
//                index = i;
//                break;
//             }
//         }
//         int nextIndex = (index+1) % ans.size();
//         List<Integer> next = ans.get(nextIndex);
//         for(int i = 0; i<nums.length; i++){
//             nums[i] = next.get(i);
        
//         }
//     }
//     public static List<List<Integer>> getPers(List<Integer> list, int idx, List<List<Integer>> ans){
//         if(idx == list.size()){
//             ans.add(new ArrayList<>(list));
//             return ans;
//         }
//         for(int i = idx; i< list.size(); i++){
//             boolean duplicate = false;
//             for(int j = idx; j<i; j++){
//                 if(list.get(j).equals(list.get(i))){
//                     duplicate = true;
//                     break;
//                 }
//             }
//             if(duplicate){
//                 continue;
//             }
//             swap(list, idx, i);
//             getPers(list, idx+1, ans);
//             swap(list, idx,i);
//         }
//         return ans;
//     }
//     public static void swap(List<Integer> list, int i, int j){
//     int temp = list.get(i);
//     list.set(i, list.get(j));
//     list.set(j, temp);
//     }
// }
    
       // OPTIMZE APPROACH
        //TC = O(3n)
       int index = -1;
       int n = nums.length;
       for(int i= n -2; i>=0; i--){
        if(nums[i] < nums[i+1]){
           index = i;
           break;
        }
       }
       if(index != -1){
       for(int i = n-1; i >=index+1; i--){
        if(nums[i] > nums[index]){
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
            break;
        }
       }
       reverse(index+1, n-1,nums);
       }
       else{
        reverse(0, n-1, nums);
       }
    }
    public static void reverse(int i , int j, int[] nums){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
