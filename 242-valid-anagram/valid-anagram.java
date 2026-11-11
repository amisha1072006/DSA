class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())    return false;
           int count1[] = new int[26];
           int count2[] = new int[26];
           for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            int idx = ch - 'a';
            count1[idx]++;
           }
           for(int i = 0; i<t.length(); i++){
            char ch = t.charAt(i);
            int idx = ch - 'a';
            count2[idx]++;
           }
         return Arrays.equals(count1, count2);
    }
}