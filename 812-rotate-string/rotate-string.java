class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        if(s.length() != goal.length()){
            return false;
        }
        if(s.isEmpty()){
            return true;
        }
        for(int shift = 0; shift < n; shift++){
            String rotated = s.substring(shift) + s.substring(0, shift);
            if(rotated.equals(goal)){
                return true;
            }
        }
        return false;
    }
}