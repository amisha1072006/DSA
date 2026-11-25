class Solution {
    public String longestCommonPrefix(String[] strs) {

        // BRUTE FORCE APPROACH
        // TC = O(nlogn * m) where n = total strings and m = maximum string length, SC = O(1)

        //   StringBuilder result = new StringBuilder();
        //   // sort the array
        //   Arrays.sort(strs);

        //   // get the first and last strings
        //   char[] first = strs[0].toCharArray();
        //   char[] last = strs[strs.length - 1].toCharArray();

        //   // start comparing
        //   for(int i = 0; i < first.length; i++){
        //     if(first[i] != last[i])
        //     break;
        //     result.append(first[i]);
        //   }
        //   return result.toString();

        // OPTIMAL APPROACH
        // TC = O(n * m), SC = O(1)

        int minLen = strs[0].length();
        for(String str: strs){
            minLen = Math.min(str.length(), minLen);
        }
        int i = 0;
        while(i < minLen){
            int j = 0;
            while(j < strs.length-1){
                if(strs[j].charAt(i) != strs[j+1].charAt(i)){
                    return strs[0].substring(0, i);
                }
                j = j+1;
            }
            i = i+1;
        }
        return strs[0].substring(0,i);
    }
}