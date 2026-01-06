class Solution {
    public int leastInterval(char[] tasks, int n) {
               int[] freq = new int[26];
        for(char task : tasks){
            freq[task-'A']++;
        }
        Arrays.sort(freq);
        int max = freq[25]-1;
        int idles = max * n;
        for(int i=freq.length-2;i>=0 && freq[i]!=0;i--){
            idles -= Math.min(max,freq[i]);
        }
        return idles>0?idles+tasks.length:tasks.length;
    
    }
}