class Solution {
    public int videoStitching(int[][] clips, int time) {
       Arrays.sort(clips,(a,b)->{ 
        return a[0]-b[0];
      });
      int ans=0;
      int e=0;
      int f=0;
      int i=0;
      while(f<time){
        while(i<clips.length&&clips[i][0]<=e){
            f=Math.max(f,clips[i++][1]);
        }
        if(f==e)return -1;
        ans++;
        e=f;
      }
      
     // if(bb!=time)return -1;
      return ans;
 
    }
}