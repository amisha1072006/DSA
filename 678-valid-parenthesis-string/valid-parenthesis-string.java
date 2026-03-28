class Solution {
    public boolean checkValidString(String s) {
               int c1 = 0 ;
        int c2 = 0;
        for (int i = 0; i < s.length(); i++) {
            char k = s.charAt(i);
            if (k == '(') {
                c1 += 1;
                c2 += 1;
            }
            else if (k == ')') {
                c1 -= 1;
                c2 = Math.max(0,c2 - 1);
            }
            else {
                c1 += 1;
                c2 = Math.max(0, c2 - 1);
            }
            if (c1 < 0) {
                return false;
            }
        }
        if (c2 == 0) {
            return true;
        }
        return false; 
    }
}