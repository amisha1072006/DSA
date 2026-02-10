class Solution {
        int m, k, n;
    int mod=(int)1e9+7;
    long[] f, invf;
    HashMap<picky, Long> mp;

    class picky{
        long pbs; int pm, pk, pi;
        picky(long pbs, int pm, int pk, int pi){
            this.pbs=pbs;
            this.pm=pm;
            this.pk=pk;
            this.pi =pi;
        }
        @Override
        public boolean equals(Object o){
            if(this==o) return true;
            if(o==null || getClass()!=o.getClass()) return false;
            picky other=(picky) o;
            return pbs==other.pbs && pm==other.pm && pk==other.pk && pi==other.pi;
        }
        @Override
        public int hashCode(){
            int h=Long.hashCode(pbs);
            h=31*h+Integer.hashCode(pm);
            h=31*h+Integer.hashCode(pk);
            h=31*h+Integer.hashCode(pi);
            return h;
        }
    }

    long findPow(long a, long b){
        if(b==0) return 1;
        long rs=1L;
        while(b>0){
            if((b&1)>0) rs=(rs*a)%mod;
            a=(a*a)%mod;
            b>>=1;
        }
        rs%=mod;
        return rs;
    }

    long ncr(int n, int r){
        if(r<0 || r>n) return 0;
        return (((f[n]*invf[r])%mod)*invf[n-r])%mod;
    }

    long optimalF(long binarySum, int m, int k, int i, int[] nums){
        picky now=new picky(binarySum, m, k, i);
        if(mp.containsKey(now)) return mp.get(now);
        if(m==0 && Long.bitCount(binarySum)==k) return 1;
        if(m==0 || i>=n) return 0;

        long totalSum=0;

        for(int freq=0; freq<=m; freq++){
            if(freq==0) totalSum=optimalF(binarySum>>1, m, k-(int)(binarySum&1), i+1, nums)%mod;
            else{
                long newBinarySum=binarySum+freq;
                long bit=newBinarySum&1;
                long carry=newBinarySum>>1;
                long prod=optimalF(carry, m-freq, k-(int)bit, i+1, nums);
                prod=(prod*ncr(m, freq))%mod;
                prod=((prod%mod)*(findPow(nums[i], freq)%mod))%mod;
                totalSum=(totalSum+prod)%mod;
            } 
        }
        mp.put(now, totalSum);
        return totalSum;
    }


    public int magicalSum(int m, int k, int[] nums) {
                n=nums.length;
        this.m=m;
        this.k=k;
        mp=new HashMap<>();
        f=new long[m+1];
        invf=new long[m+1];

        f[0]=1;
        for(int i=1; i<=m; i++) f[i]=(f[i-1]*i)%mod;
        invf[m]=findPow(f[m], mod-2);
        for(int i=m-1; i>=0; i--){
            invf[i]=(invf[i+1]*(i+1))%mod;
        }

        return (int) optimalF(0, m, k, 0, nums)%mod;
    
    }
}