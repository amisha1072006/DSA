class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];
        boolean[] vis = new boolean[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()){
            freq[c-'a']--;
            if(vis[c-'a']){
                continue;
            }
            while(!st.isEmpty() && st.peek() > c && freq[st.peek()-'a'] > 0){
                vis[st.pop()-'a'] = false;
            }
            st.push(c);
            vis[c-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : st){
            sb.append(c);
        }
        return sb.toString();
    
    }
}