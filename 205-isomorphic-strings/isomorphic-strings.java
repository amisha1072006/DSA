class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        // BRUTE FORCE APPROACH
        // TC = O(), SC = O()

        HashMap<Character,Character> sToTMap = new HashMap<>();
        HashMap<Character,Character> tToSMap = new HashMap<>();
        int n = s.length();
        for(int i = 0; i<n; i++){
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            if(!sToTMap.containsKey(s1)){
                sToTMap.put(s1,t1);
            }
            if(!tToSMap.containsKey(t1)){
                tToSMap.put(t1, s1);
            }
            if(sToTMap.get(s1) != t1 || tToSMap.get(t1) != s1){
                return false;
            }
        }
        return true;
    }
}