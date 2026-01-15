class Solution {
        public boolean isPrefixAndSuffix(String s1, String s2){

        if(s2.indexOf(s1)!=0){
            return false;
        }
        if(s2.lastIndexOf(s1)!=(s2.length()-s1.length())){
            return false;
        }
        return true;
    }
    public int countPrefixSuffixPairs(String[] words) {
        int ans=0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(isPrefixAndSuffix(words[i], words[j])){
                    ans++;
                }
            }
        }
        return ans;
    
    }
}