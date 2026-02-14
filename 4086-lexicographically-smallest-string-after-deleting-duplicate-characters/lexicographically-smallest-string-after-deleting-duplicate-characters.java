class Solution {
    public String lexSmallestAfterDeletion(String s) {
                int freq[]=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }

        StringBuilder sb=new StringBuilder();

        for(char ch:s.toCharArray()){
            
            while(sb.length()>0){
                char last=sb.charAt(sb.length()-1);
                if(last>ch && freq[last-'a']>1){
                    sb.deleteCharAt(sb.length()-1);
                    freq[last-'a']--;
                }
                else{
                    break;
                }
            }
            sb.append(ch);
        }
        
        while(sb.length()>0){
                char last=sb.charAt(sb.length()-1);
                if(freq[last-'a']>1){
                    sb.deleteCharAt(sb.length()-1);
                    freq[last-'a']--;
                }
                else{
                    break;
                }
            }
        return sb.toString();
    
    }
}