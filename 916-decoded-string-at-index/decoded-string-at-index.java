class Solution {
    public String decodeAtIndex(String s, int k) {
        
        int n = s.length();

        long len = 0;
        for(int i =0;i<n;i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) len *= ch - '0';
            else len++;
        }

        int idx = n - 1;
        while(idx >= 0){
            k = (int)(k % len);
            char ch = s.charAt(idx);
            if(Character.isDigit(ch)) len = len / Integer.parseInt(String.valueOf(ch));
            else if (k != 0) len--;
            else {
                return String.valueOf(ch);
            }
            idx--;
        }

        return "";
    }
}