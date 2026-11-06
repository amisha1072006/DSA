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

//         int m = nums1.length;
//         int n = nums2.length;
//         int x = (m + n);
//         int idx2 = x / 2;
//         int idx1 = idx2 - 1;
//         int cnt = 0;
//         int i = 0;
//         int j = 0;
//         int idxele1 = -1;
//         int idxele2 = -1;
//         while(i < m && j < n){
//             if(nums1[i] < nums2[j]){
//                 if(cnt == idx1) idxele1 = nums1[i];
//                 if(cnt == idx2) idxele2 = nums1[i];
//                 i++;
//                 cnt++;
//             }
//             else{
//                 if(cnt == idx1) idxele1 = nums2[j];
//                 if(cnt == idx2) idxele2 = nums2[j];
//                 j++;
//                 cnt++;
//             }
//         }
//             while(i < m){
//                if(cnt == idx1) idxele1 = nums1[i];
//                 if(cnt == idx2) idxele2 = nums1[i];
//                 i++;
//                 cnt++; 
//             }
//             while(j < n){
//                 if(cnt == idx1) idxele1 = nums2[j];
//                 if(cnt == idx2) idxele2 = nums2[j];
//                 j++;
//                 cnt++;
//             }
//             if(x % 2 == 1){
//                 return idxele2;
//             }
//             return (idxele1 + idxele2) / 2.0;
//         }
// }

        // OPTIMAL APPROACH
        // TC = log(m + n), SC = O(1)

        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2){
            return findMedianSortedArrays(nums2, nums1);
        }
        int n = (n1 + n2);
        int left = (n1 + n2 + 1)/2;
        int low = 0;
        int high = n1;
        while(low <= high){
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(mid1 < n1){
                r1 = nums1[mid1];
            }
            if(mid2 < n2){
                r2 = nums2[mid2];
            }
            if(mid1-1 >= 0){
                l1 = nums1[mid1 - 1];
            }
            if(mid2 - 1 >= 0){
                l2 = nums2[mid2 - 1];
            }
            if(l1 <= r2 && l2 <= r1){
                if(n % 2 == 1) return Math.max(l1, l2);
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }
            else if(l1 > r2){
                high = mid1 - 1;
            }
            else{
                low = mid1 + 1;
            }
        }
        return 0;
    }
}

        
