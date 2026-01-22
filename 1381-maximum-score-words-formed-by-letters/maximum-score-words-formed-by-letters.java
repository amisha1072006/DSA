class Solution {
        int max=0;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
               int[] freq=new int[26];
        for(char c:letters){
            freq[c-'a']++;
        }
        backtrack(words,freq,score,0,0);

        return max;
    }


    public void backtrack(String[] words, int[] freq, int[] score,int i,int cur){

        if(i>=words.length){
            max=Math.max(max,cur);
            return;
        }

        // int score=0;

        for(int j=i;j<words.length;j++){

            boolean flag=true;
            int k=0;
            for(char c:words[j].toCharArray()){
                if(freq[c-'a']==0){
                    flag=false;
                    break;
                }
                cur+=score[c-'a'];
                freq[c-'a']--;
                k++;
                
            }
           
            if(!flag){
                for(int l=0;l<k;l++){
                    freq[words[j].charAt(l)-'a']++;
                    cur-=score[words[j].charAt(l)-'a'];
                }
                continue;
            }

            //  System.out.println(cur);
             max=Math.max(max,cur);
            backtrack(words,freq,score,j+1,cur);

            for(char c:words[j].toCharArray()){
                
                cur-=score[c-'a'];
                freq[c-'a']++;
                
            }


        }
 
    }
}