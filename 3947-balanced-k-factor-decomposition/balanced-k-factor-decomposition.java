class Solution {
    long res=100000;
    int out[];
    public int[] minDifference(int n, int k) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        out= new int[k];
        for(int i=1;i<=Math.sqrt(n);i++){
                if(n%i==0){
                    arr.add(i);
                }
        }
         System.out.println(arr);   
        dfs(arr,k,1,100000,1,n,new ArrayList<Long>(),k);
        return out;
    }

        public void dfs(ArrayList<Integer> arr,int k,long max,long min,long val,int n,ArrayList<Long> ans,int K){

        if(k==1){
            if(n%val==0){
                    ans.add(n/val);
                    
                    max=Math.max(max,n/val);
                    min=Math.min(min,n/val);
                    if(res>max-min){
                        res=max-min;
                        //System.out.println(ans);
                        for(int j=0;j<K;j++){
                            long v=ans.get(j);
                            out[j]=(int)v;
                        }
                        //System.out.println(out[1]);
                    }
                    ans.removeLast();
                }

                return;
            }

            for(int i: arr){
                ans.add((long)i);
                dfs(arr,k-1,Math.max(max,i),Math.min(min,i),val*i,n,ans,K);
                ans.removeLast();
            }
    }
}