class Solution {
    public int findLongestChain(int[][] pairs) {
                Arrays.sort(pairs,(a,b)->(a[1]-b[1]));
        int curr=Integer.MIN_VALUE;
        int len=0;
        for(int arr[]:pairs){
            if(curr<arr[0]){
                len++;
                curr=arr[1];
            }
        }
        return len;
    }
}