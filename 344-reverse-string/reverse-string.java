class Solution {
    public void reverseString(char[] s) {

    // BRUTE FORCE APPROACH
    // TC = O(n), SC = O(n)

    int n = s.length;
    char[] ans = new char[n];
    int k = 0;
    for(int i = n-1; i >= 0; i--){
        ans[k++] = s[i];
    }
    for(int i = 0; i < n; i++){
         s[i] = ans[i];
    }
    }
}

       // OPTIMAL APPROACH
       // TC = O(n), SC = O(1)

//         int n = s.length;
//         int i = 0;
//         int j = n-1;
//         while(i < j){
//         char temp = s[i];
//         s[i] = s[j];
//         s[j] = temp;
//             i++;
//             j--;
//         }
//     }
// }