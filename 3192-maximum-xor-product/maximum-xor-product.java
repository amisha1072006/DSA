class Solution {
    public int maximumXorProduct(long a, long b, int n) {
              long tempA = a;
        long tempB = b;

        long mask = (1L << n)-1;

        tempA = (tempA & ~mask);
        tempB = (tempB & ~mask); 


        for(int i = n-1; i>=0; i--){
            long temp = 1L << i;
            if(((a >> i) & 1) == ((b >> i) & 1)){
                tempA |= temp;
                tempB |= temp;
            }
            else{
                if(tempA > tempB){
                    tempB |= temp;
                }
                else{
                    tempA |= temp;
                }
            }
        }
        int mod = 1000000007;
        long ans = ((tempA%mod) * (tempB%mod))%mod;
        return (int)(ans%mod);
  
    }
}