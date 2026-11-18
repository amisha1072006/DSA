class Solution {
    public String largestOddNumber(String num) {

        int n = num.length();
        int idx = -1;
        for(int i = n-1; i >= 0; i--){
            if(num.charAt(i) % 2 != 0){
                idx = i;
                break;
            }
        }
        if(idx == -1)
        return "";
        char str[] = new char[idx +1];
        for(int i = 0; i<= idx; i++){
            str[i] = num.charAt(i);
        }
        return new String(str);
    }
}

        // int n = num.length();
        // for(int i = n-1; i >= 0; i--){
        //     if(num.charAt(i) % 2 != 0){
        //         return num.substring(0, i+1);
        //     }
        // }
        // return "";
//     }
// }