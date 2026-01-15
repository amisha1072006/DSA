class Solution {
    public int minValidStrings(String[] words, String target) {
      int total=0;
        for(String w:words) total+=w.length();
        int maxNodes=total+1,alpha=26;
        int[] next=new int[maxNodes*alpha];
        int[] fail=new int[maxNodes];
        int[] depth=new int[maxNodes];
        int nodes=1; 
        for(String w:words){
            int u=0;
            for(int k=0;k<w.length();k++){
                int c=w.charAt(k)-'a';
                int idx=u*alpha+c;
                if(next[idx]==0){
                    next[idx]=nodes;
                    depth[nodes]=depth[u]+1;
                    nodes++;
                }
                u=next[idx];
            }
        }
        int[] q=new int[nodes];
        int h=0,t=0;
        for(int c=0;c<alpha;c++){
            int v=next[c];
            if(v!=0){ fail[v]=0; q[t++]=v; }
        }
        while(h<t){
            int u=q[h++];
            for(int c=0;c<alpha;c++){
                int v=next[u*alpha+c];
                if(v!=0){
                    int f=fail[u];
                    while(f>0&&next[f*alpha+c]==0) f=fail[f];
                    if(next[f*alpha+c]!=0) f=next[f*alpha+c];
                    fail[v]=f;
                    q[t++]=v;
                }
            }
        }
        int n=target.length();
        int[] len=new int[n];
        int state=0;
        for(int j=0;j<n;j++){
            int c=target.charAt(j)-'a';
            while(state>0&&next[state*alpha+c]==0) state=fail[state];
            if(next[state*alpha+c]!=0) state=next[state*alpha+c];
            else state=0;
            len[j]=depth[state];
        }
        int ans=0,i=0,p=0,far=-1;
        while(i<n){
            while(p<n && (len[p]>0 ? p-len[p]+1 : p+1) <= i){
                far=Math.max(far,p);
                p++;
            }
            if(far<i) return -1;
            i=far+1;
            ans++;
        }
        return ans;
      
    }
}