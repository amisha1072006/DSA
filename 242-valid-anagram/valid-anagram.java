class Solution {
    public boolean isAnagram(String s, String t) {
     
     // BRUTE FORCE APPROACH
     // TC = O(n^2), SC = O(n)

//     if(s.length() != t.length()) return false;
//     char[] arr = t.toCharArray();
//     for(int i = 0; i<s.length(); i++){
//         boolean found = false;
//         for(int j = 0; j<arr.length; j++){
//             if(s.charAt(i) == arr[j]){
//                 arr[j] = '*';
//                 found = true;
//                 break;
//             }
//         }
//         if(found == false) return false;
//     }
//     return true;
//     }
// }


  // BETTER APPROACH
  // TC = O(), SC = O()

  char[] str1CharArray = s.toCharArray();
  char[] str2CharArray = t.toCharArray();
  Arrays.sort(str1CharArray);
  Arrays.sort(str2CharArray);
  boolean result = Arrays.equals(str1CharArray, str2CharArray);
  if(result){
    return true;
  }
  return false;
    }
}

        // OPTIMAL APPROACH
        // TC = O(n), SC = O(n)

//         if(s.length() != t.length()) return false;
//            int count1[] = new int[26];
//            int count2[] = new int[26];
//            for(int i = 0; i<s.length(); i++){
//             char ch = s.charAt(i);
//             int idx = ch - 'a';
//             count1[idx]++;
//            }
//            for(int i = 0; i<t.length(); i++){
//             char ch = t.charAt(i);
//             int idx = ch - 'a';
//             count2[idx]++;
//            }
//          return Arrays.equals(count1, count2);
//     }
// }