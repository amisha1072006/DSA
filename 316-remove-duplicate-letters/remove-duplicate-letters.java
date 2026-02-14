class Solution {
    public String removeDuplicateLetters(String t) {
       char[]s = t.toCharArray();
        
        int []visited = new int[26];
        int[] freq  =new int [26];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        int n=s.length;
        
        for(int i=0;i<n;i++){
            freq[s[i]-'a']++;
        }

        for(int i=0;i<n;i++){
            freq[s[i]-'a']--;
            if(visited[s[i]-'a']>0)continue;
            while(!dq.isEmpty()&&s[dq.peekFirst()]>s[i]&&freq[s[dq.peekFirst()]-'a']>0){
                visited[s[dq.peekFirst()]-'a']=0;
                dq.poll();
            }
            visited[s[i]-'a']=1;
            dq.offerFirst(i);
        }



        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()){
            sb.append(s[dq.pollLast()]);
        }
        return sb.toString();
        
    
    }
}