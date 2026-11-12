class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        // BRUTE FORCE APPROACH
        // TC = O(n) but in worst case O(n^2), SC = O(2n)

//         HashMap<Character,Character> sToTMap = new HashMap<>();
//         HashMap<Character,Character> tToSMap = new HashMap<>();
//         int n = s.length();
//         for(int i = 0; i<n; i++){
//             char s1 = s.charAt(i);
//             char t1 = t.charAt(i);
//             if(!sToTMap.containsKey(s1)){
//                 sToTMap.put(s1,t1);
//             }
//             if(!tToSMap.containsKey(t1)){
//                 tToSMap.put(t1, s1);
//             }
//             if(sToTMap.get(s1) != t1 || tToSMap.get(t1) != s1){
//                 return false;
//             }
//         }
//         return true;
//     }
// }

// OPTIMAL APPROACH
// TC = O(), SC = O()

int n = s.length();
int[] sToTMap = new int[128];
int[] tToSMap = new int[128];
Arrays.fill(sToTMap, -1);
Arrays.fill(tToSMap, -1);
StringBuilder sbS = new StringBuilder(s);
StringBuilder sbT = new StringBuilder(t);
for(int i = 0; i<n; i++){
    char s1 = sbS.charAt(i);
    char t1 = sbT.charAt(i);
    if(sToTMap[s1] == -1){
        sToTMap[s1] = t1;
    }
    if(tToSMap[t1] == -1){
        tToSMap[t1] = s1;
    }
    if(sToTMap[s1] != t1 || tToSMap[t1] != s1){
        return false;
    }
}
return true;
    }
}


