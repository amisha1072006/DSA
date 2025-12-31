class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
               int m=nums1.length;
        int n=nums2.length;
        int arr[]=new int[m+n];
        int i=0;   // for nums1
        int j=0;   // for nums2;
        int k=0;   // for filling
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]<nums2[j]){
                arr[k++]=nums1[i++];
            }else{
                arr[k++]=nums2[j++];
            }
        }
        while(i<nums1.length){
            arr[k++]=nums1[i++];
        }
        while(j<nums2.length){
            arr[k++]=nums2[j++];
        }
        int total=m+n;
        if(total%2==1)return arr[total/2];
        return (arr[total/2]+arr[(total/2)-1])/2.0;
 
    }
}