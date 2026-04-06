class Solution {
    public int longestSubsequence(int[] arr, int diff) {
               HashMap<Integer,Integer> hp = new HashMap<>();
        int n = arr.length;
        int ans = 1;
        for(int i=0; i<n; i++){
            if(hp.containsKey(arr[i]-diff)){
                hp.put(arr[i],hp.get(arr[i]-diff)+1);
                ans = Math.max(ans,hp.get(arr[i]));
            }else hp.put(arr[i],1);
        }
        return ans;
 
    }
}