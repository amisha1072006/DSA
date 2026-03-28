class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
              int score=0;
        int res=0;

        Arrays.sort(tokens);
        

        int l=0;
        int r=tokens.length-1;
        while(l<=r){
            if(tokens[l]<=power){
                power-=tokens[l];
                l+=1;
                score+=1;
                res = Math.max(score,res);

            }
          else if(score>0){
            power+=tokens[r];
            r-=1;
            score-=1;
           }
           else{
            break;
           }

        }
        return res;  
    }
}