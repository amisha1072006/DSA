class Solution {
    public boolean isPalindrome(String s) {

        // BRUTE FORCE APPROACH
        // TC = O(), SC = O()

        int n = s.length();
        return palindrome(s, 0, n-1);
    }
    public boolean palindrome(String s, int left, int right){
        if(left >= right){
            return true;
        }
        if(!isAlphaNum(s.charAt(left))){
            return palindrome(s, left+1, right);
        }
        if(!isAlphaNum(s.charAt(right))){
            return palindrome(s, left, right-1);
        }
        if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
            return false;
        }
        return palindrome(s, left+1, right-1);
    }
    public static boolean isAlphaNum(char ch){
        if((ch >= '0' && ch <= '9') || (Character.toLowerCase(ch) >= 'a' && Character.toLowerCase(ch) <= 'z')){
            return true;
        }
        return false;
    }
}
     
        // OPTIMAL APPROACH
        // TC = O(n), SC = O(1)

//         int n = s.length();
//         int i = 0;
//         int j = n-1;
//         while(i < j){
//             if(!isAlphaNum(s.charAt(i))){
//              i++;
//              continue;
//             }
//             if(!isAlphaNum(s.charAt(j))){
//                 j--;
//                 continue;
//             }
//             if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
//                 return false;
//             }
//             i++;
//             j--;
//         }
//         return true;
//     }
//     public static boolean isAlphaNum(char ch){
//         if((ch >= '0' && ch <= '9') || (Character.toLowerCase(ch) >= 'a' && Character.toLowerCase(ch) <= 'z')){
//             return true;
//         }
//         return false;
//     }
// }