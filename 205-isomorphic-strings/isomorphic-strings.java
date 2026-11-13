class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        // BRUTE FORCE APPROACH
        // TC = O(n) in best, average and worst also because here keys are Character and valid ASCII characters are 256 only so bucket size cannot increase beyond constant (max 256) so, practically in worst case time complexity will be O(n), SC = O(1), since map size is fixed to 128 ASCII characters

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
// TC = O(3n) = O(n), SC = O(1), since arr size is fixed to 128 ASCII characters

int n = s.length();
int[] sToTMap = new int[128];
int[] tToSMap = new int[128];
Arrays.fill(sToTMap, -1);
Arrays.fill(tToSMap, -1);
for(int i = 0; i<n; i++){
    char s1 = s.charAt(i);
    char t1 = t.charAt(i);
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


