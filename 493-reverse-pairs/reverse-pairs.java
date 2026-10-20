class Solution {
    public int reversePairs(int[] arr) {

        // BRUTE FORCE APPROACH
        // TC = O(n^2), SC = O(1)

//         int cnt = 0; 
//         int n = arr.length;
//         for(int i = 0; i<n; i++){
//             for(int j = i+1; j<n; j++){
//                 if(arr[i] > 2L * arr[j]){
//                     cnt++;
//                 }
//             }
//         }
//         return cnt ;
//     }
// }

         // OPTIMAL APPROACH
         // TC = O(2nlogn), SC = O(n)

             int n = arr.length;
             return mergeSort(arr, 0, n-1);
    }  
    // TC = O(nlogn), SC = O(1)
    public static int mergeSort(int arr[], int si, int ei){
            int cnt = 0;
            if(si>= ei){
                return cnt;
            }
            int mid = si + (ei-si)/2;
            cnt += mergeSort(arr, si, mid);
            cnt += mergeSort(arr, mid+1, ei);
            cnt += reversePair(arr, si, mid, ei);
            merge(arr, si, mid, ei);
            return cnt;
        }
        // TC = O(n), SC = O(n)
        public static void merge(int arr[], int si, int mid, int ei){
            int temp[] = new int[ei-si+1];
            int i = si;
            int j = mid+1;
            int k = 0;
           while(i<= mid && j<= ei){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
           }
           while(i<= mid){
            temp[k++] = arr[i++];
           }
           while(j<= ei){
             temp[k++] = arr[j++];
           }
           for(k = 0; k< temp.length; k++){
            arr[si+k] = temp[k];
           }
           }
        //    O(n1+n2) = O(n)
        public static int reversePair(int[] arr, int si, int mid, int ei){
            int cnt = 0;
            int j = mid+1;
            for(int i = si; i<=mid; i++){
                while(j <= ei && (long) arr[i] > 2L * arr[j]){
                    j++;
                }
                    cnt += (j- (mid + 1));
            }

            // OR

            // int cnt = 0;
            // int i = si;
            // int j = mid+1;
            // while(i <= mid && j <= ei){
            //     if((long) arr[i] > 2L * arr[j]){
            //        cnt += mid - i + 1;
            //         j++;
            //     } else{
            //         i++;
            //     }
            // }
            return cnt;
        }
}