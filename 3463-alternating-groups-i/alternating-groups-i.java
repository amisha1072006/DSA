class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
       int c=0;
        int n=colors.length;
        if(n<3){
            return c;
        }
        for(int i=0;i<n-2;i++){
            if(colors[i]==colors[i+2] && colors[i]!=colors[i+1]){
                c++;
            }
        }
        if(colors[0]==colors[n-2] && colors[n-1]!=colors[0]){
            c++;
        }
        if(colors[n-1]==colors[1] && colors[0]!=colors[n-1]){
            c++;
        }
        return c;
     
    }
}