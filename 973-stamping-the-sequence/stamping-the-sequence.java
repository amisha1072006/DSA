class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] stamps = stamp.toCharArray(), targets = target.toCharArray();
        int count[] = new int[1], n = targets.length, ii = 0; 
        HashSet<Integer> set = new HashSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        while(count[0]<n){
            int fl=0;
            for(int i=0;i<(n-stamps.length+1);i++){
                if(!set.contains(i) &&  possibilityOfEquality(i,stamps,targets)){
                    list.add(i); set.add(i);
                    ii++;
                    replace(i,targets,stamps.length,count);
                    fl=1;
                    break;
            
    }
}
            if(fl==0) return new int[0];
        }
        int res[]=new int[list.size()];
        for(int values : list) res[ii-- -1]=values;
        return res;
    }
    boolean possibilityOfEquality(int i, char[] stamp, char[] target){
        int countq=0;
        for(char ch : stamp){
            if(target[i]!='?' && ch!=target[i])
                return false;
            if(target[i]=='?') countq++;
            i++;
        }
        return countq!=stamp.length;
    }
    
    void replace(int i, char[] target,int n, int[] count){
        for(int k=n+i;i<k;i++){
            if(target[i]!='?')count[0]++;
            target[i]='?';
        }
    }
}