class Solution {
    public int compress(char[] chars) {
        int j=0;
        for(int i =0; i<chars.length; i++){
            int count =1;
            while(i<chars.length-1 && chars[i] == chars[i+1]){
                count++;
                i++;
            }
           chars[j++] = chars[i];
           if(count >1){
            String s = String.valueOf(count);
            for(int k =0; k<s.length(); k++){
                chars[j++] = s.charAt(k);
            }
           }
        }
        return j;
    }
}