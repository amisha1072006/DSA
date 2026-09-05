class Solution {
     //public void rotate(int[] nums, int k) {
     // BRUTE FORCE APPROACH
     // TC = O(n*k), SC =O(1)
    //  int n = nums.length;
    //  k = k % n;
    //  for(int r =1; r<=k; r++){
    //      int temp = nums[n-1];
    //      for(int i = n-1; i>0;i--){
    //         nums[i] = nums[i-1];
    //      }
    //      nums[0] = temp;

         //FOR LEFT ROTATION
         //int temp = nums[0];
         //for(int i = 0; i< n-1;i++){
           // nums[i] = nums[i+1];
         //}
         //nums[n-1] = temp;
//      }
//      }
// }
        // BETTER APPROACH 
        // TC = O(n) , SC = O(k) but in worst case SC = O(n) due to given constraints
//         int n = nums.length;
//         k = k%n;
//         int temp[] = new int[k];
//         int j = 0;
//     for(int i = n-k; i <n; i++){
//        temp[j++] = nums[i];
//     }
//     for(int i = n-k-1; i>= 0; i--){
//      nums[i+k] = nums[i];
//    }
//    for(int  i =0; i<k; i++)
//     {
//      nums[i] = temp[i];
//     }

// FOR LEFT ROTATION
// k = k % n;
// int[] temp = new int[k];
// int j = 0;
// for(int i = 0; i < k; i++) {
//     temp[j++] = nums[i];
// }
// for(int i = k; i < n; i++) {
//     nums[i-k] = nums[i];
// }
// j = 0;
// for(int i = n-k; i < n; i++) {
//     nums[i] = temp[j++];
// }


//      }
//         }

    //OPTMISE SOLUTION
    //TC = O(n), SC = O(1)
   public static void swap(int i,int j,int arr[]){
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;j--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
           swap(0,n-1,nums);
            swap(0,k-1,nums);
            swap(k,n-1,nums);   

// FOR LEFT ROTATION 
// swap(0,k-1,nums);
// swap(k,n-1,nums);
// swap(0,n-1,nums);   
    }

    }
