class Solution {
    public boolean hasAllCodes(String s, int k) {
       int need = 1 << k; 
        
        if (s.length() < k) return false;

        HashSet<String> st = new HashSet<>();
        
        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            st.add(sub);
            
            if (st.size() == need) {
                return true;
            }
        }
        
        return false;

         
    }
}