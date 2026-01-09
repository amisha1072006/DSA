class Solution {
    int sum;
    int n;
    int[] indexArr;
    public Solution(int[] w) {
        sum = 0;
  
       indexArr = new int[w.length];
       for(int i = 0; i < w.length; i ++) {
           sum += w[i];
           indexArr[i] = sum;
       }  
           n = w.length;
       
    }
    
    public int pickIndex() {
                if(n == 1) {
            return 0;
        }
        int rnd = (int)(Math.random() * (sum ));
        int left = 0;
        int right = n - 1;
        while(left < right) {
            int mid = left + (right - left) /2 ;
         if(rnd < indexArr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */