class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int [] s2freq = new int[26];
        int [] s1freq = new int[26];
        for (int i=0;i<s1.length();i++){
            s1freq[s1.charAt(i)-'a']++;
        }
        int start = 0;
        int end = 0;
        while (end < s2.length()){
            s2freq[s2.charAt(end)-'a']++;
            if(end-start+1 == s1.length()){
                if(Arrays.equals(s1freq,s2freq)){
                    return true;
                }
                s2freq[s2.charAt(start)-'a']--;
                start++;
            }
            end++;
        }
        return false;
   
    }
}