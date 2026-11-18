class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n-1;
        while(i < j){
            if(!isAlphaNum(s.charAt(i))){
             i++;
             continue;
            }
            if(!isAlphaNum(s.charAt(j))){
                j--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static boolean isAlphaNum(char ch){
        if((ch >= '0' && ch <= '9') || (Character.toLowerCase(ch) >= 'a' && Character.toLowerCase(ch) <= 'z')){
            return true;
        }
        return false;
    }
}