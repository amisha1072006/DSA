class Solution {
    public int lenLongestFibSubseq(int[] arr) {
                Set<Integer> set = new HashSet<>();

        for(int e : arr){ 
            set.add(e);
        }

        int n = arr.length, ans = 0;

        for(int i=0 ; i<n ; i++){
            for(int j=i+1 ; j<n ; j++){
                int prev = arr[i], curr = arr[j];
                int next = prev + curr;

                int len = 2;

                while(set.contains(next)){
                    len++;
                    prev = curr;
                    curr = next;

                    next = prev + curr;

                    ans = Math.max(ans, len);
                }
            }
        }

        return ans;
    }
}