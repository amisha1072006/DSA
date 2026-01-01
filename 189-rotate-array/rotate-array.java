class Solution {
    static void swap(int i,int j,int arr[]){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int i = 0;
        int j = n-1;
        while(i<j){
           swap(i,j,nums);
           i++;
           j--;
           }
           int m=0,p=k-1;
         while(m<p){
            swap(m,p,nums);
            m++;
            p--;
         } 
         int f=k,q=n-1;
         while(f<q){
            swap(f,q,nums);
            f++;
            q--;
         }       

    }
}