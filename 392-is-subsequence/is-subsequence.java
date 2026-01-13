class Solution {
    public boolean isSubsequence(String s, String t) {
                if (s.isEmpty()) return true;

        int index = -1;
        for (char ch : s.toCharArray()) {
            index = t.indexOf(ch, index + 1);
            if (index == -1) return false;
        }

        return true;
    
    }
}