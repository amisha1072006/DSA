class Solution {
    static void swap(int i,int j,int arr[]){
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

    }
}