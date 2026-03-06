class Solution {
    public int hIndex(int[] arr) {
        var count = new int[1002];
        for (var num :arr){
            count[0]++;
            count[num+1]--;
        }
        
        var max = 0 ; 
        for (int i=0,cnt=0;i<count.length;i++){
            cnt+=count[i];
            if (cnt>=i) max=i;
        }
        return max;  
    }
}