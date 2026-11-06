class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // BRUTE FORCE APPROACH
        // TC = O(m + n), SC = O(m + n)

//         int m=nums1.length;
//         int n=nums2.length;
//         int arr[]=new int[m+n];
//         int i=0;   
//         int j=0;   
//         int k=0;   
//         while(i < m && j < n){
//             if(nums1[i] < nums2[j]){
//                 arr[k++] = nums1[i++];
//             }else{
//                 arr[k++] = nums2[j++];
//             }
//         }
//         while(i < m){
//             arr[k++] = nums1[i++];
//         }
//         while(j < n){
//             arr[k++] = nums2[j++];
//         }
//         int total = m+n;
//         if(total % 2 == 1) return arr[total/2];
//         return (arr[total / 2] + arr[(total/2)-1]) / 2.0;
//     }
// }

        // BETTER APPROACH
        // TC = O(m + n), SC = O(1)

        int m = nums1.length;
        int n = nums2.length;
        int x = (m + n);
        int idx2 = x / 2;
        int idx1 = idx2 - 1;
        int cnt = 0;
        int i = 0;
        int j = 0;
        int idxele1 = -1;
        int idxele2 = -1;
        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                if(cnt == idx1) idxele1 = nums1[i];
                if(cnt == idx2) idxele2 = nums1[i];
                i++;
                cnt++;
            }
            else{
                if(cnt == idx1) idxele1 = nums2[j];
                if(cnt == idx2) idxele2 = nums2[j];
                j++;
                cnt++;
            }
        }
            while(i < m){
               if(cnt == idx1) idxele1 = nums1[i];
                if(cnt == idx2) idxele2 = nums1[i];
                i++;
                cnt++; 
            }
            while(j < n){
                if(cnt == idx1) idxele1 = nums2[j];
                if(cnt == idx2) idxele2 = nums2[j];
                j++;
                cnt++;
            }
            if(x % 2 == 1){
                return idxele2;
            }
            return (idxele1 + idxele2) / 2.0;
        }
}