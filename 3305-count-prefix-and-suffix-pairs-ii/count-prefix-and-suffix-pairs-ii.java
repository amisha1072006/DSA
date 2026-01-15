class Solution {
       private long mod = (long)1e9+7;
    public long countPrefixSuffixPairs(String[] words) {
              long res = 0;
      HashMap<Long,Long> map = new HashMap<>();

      for(String s : words){
         int n = s.length(); long cur = 0 , prev_cur = 0;
     
         for(int i = 0; i<n; i++){
             long cur_pow = bipow(31,i);
            cur = (cur *31 + s.charAt(i) - 'a' + 1)%mod;
            prev_cur = (prev_cur + mul(s.charAt(n-i-1)-'a'+1,cur_pow))%mod;
            if(cur == prev_cur)res += map.getOrDefault(cur,0l);
         }
         map.put(cur,map.getOrDefault(cur,0l)+1l);
      }
      return res;
   }
   public long bipow(long n , int pow){
       if(pow == 0)return 1;
       
       long res = bipow(n,pow/2);
       
       res = (res*res)%mod;
       
       return pow%2==1?(n*res)%mod:res;
       
    }
                        
   public long mul(long a, long b){
       return (a*b)%mod;
   
    }
}