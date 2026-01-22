class Solution {
    public int countCharacters(String[] words, String chars) {
       int freq[]=new int[26];
        for(char ch:chars.toCharArray()){
            freq[ch-'a']++;
        }
        int count=0;
        for(String str:words){
            int freq2[]=new int[26];
            for(char ch:str.toCharArray()){
                 freq2[ch-'a']++;
            }
            boolean flag=true;
             for(int i=0;i<26;i++){
                if(freq2[i]>freq[i]){
                    flag=false;
                }
             }
             if(flag){
                count+=str.length();
             }
                   
                }
                
            
        return count;
     
    }
}