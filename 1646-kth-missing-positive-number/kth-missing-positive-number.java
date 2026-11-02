class Solution {
    public int findKthPositive(int[] arr, int k) {
    
    // BRUTE FORCE APPROACH
    // TC = O((n + k) * logn), SC = O(1)

//         int n = arr.length;
//         int range = arr[n-1] + k;
//         int missCount = 0;
//         for(int i = 1; i<= range; i++){
//             if(missInteger(arr, i) == true){
//                 missCount++;
//             }
//             if(missCount == k){
//                 return i;
//             }
//         }
//         return -1;
//     }
//     public static boolean missInteger(int[] arr, int i){
//         int left = 0;
//         int right = arr.length-1;
//         while(left <= right){
//             int mid = left + (right - left)/2;
//             if(arr[mid] == i){
//                 return false;
//             }
//             else if(arr[mid] < i){
//                 left = mid + 1;
//             }
//             else{
//                 right = mid -1;
//             }
//         }
//         return true;
//     }
// }

     // BETTER APPROACH
    // TC = O(n), SC = O(1)

//         int n = arr.length;
//         for(int i = 0; i<n; i++){
//             if(arr[i] <= k){
//                 k++;
//             }
//         }
//         return k;
//     }
// }

    // OPTIMAL APPROACH
    // TC = O(logn), SC = O(1)

    int n = arr.length;
    int left = 0;
    int right = n-1;
    while(left <= right){
        int mid = (left + right)/2;
        int missInteger = arr[mid] - (mid + 1);
        if(missInteger < k){
            left = mid + 1;
        } 
        else{
            right = mid - 1;
        }
    }
    return right + k + 1;
    }
}
