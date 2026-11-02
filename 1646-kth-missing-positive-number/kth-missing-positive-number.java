class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int range = arr[n-1] + k;
        int missCount = 0;
        for(int i = 1; i<= range; i++){
            if(missInteger(arr, i) == true){
                missCount++;
            }
            if(missCount == k){
                return i;
            }
        }
        return -1;
    }
    public static boolean missInteger(int[] arr, int i){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] == i){
                return false;
            }
            else if(arr[mid] < i){
                left = mid + 1;
            }
            else{
                right = mid -1;
            }
        }
        return true;
    }
}