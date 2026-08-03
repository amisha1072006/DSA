class Solution {
     public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        int temp[] = new int[k];
        int j = 0;
    for(int i = n-k; i <n; i++){
       temp[j++] = nums[i];
    }
    for(int i = n-k-1; i>= 0; i--){
     nums[i+k] = nums[i];
   }
   for(int  i =0; i<k; i++)
    {
     nums[i] = temp[i];
    }

     }
        }

    //OPTMISE SOLUTION
//     static void swap(int i,int j,int arr[]){
//         while(i<j){
//             int temp = arr[i];
//             arr[i] = arr[j];
//             arr[j] = temp;
//             i++;j--;
//         }
//     }
//     public void rotate(int[] nums, int k) {
//         int n = nums.length;
//         k = k % n;
//            swap(0,n-1,nums);
//             swap(0,k-1,nums);
//             swap(k,n-1,nums);      

//     }
// }