class Solution {
    public int kthFactor(int n, int k) {
        int j=0;
    
        int[]arr=new int[k];

        for(int i=1; i<=n;i++){
    if(n%i==0){
arr[j++]=i;

if(j==k)return arr[j-1];
    }

        }
        return -1;
    
    }
}