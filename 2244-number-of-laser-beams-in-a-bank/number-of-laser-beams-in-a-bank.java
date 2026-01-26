class Solution {
    public int numberOfBeams(String[] bank) {
               int[] arr=new int[bank.length];
        for(int i=0;i<bank.length;i++){
            int count=0;
            for(char ch:bank[i].toCharArray()){
                if(ch=='1') count++;
            }
            arr[i]=count;
        }
        int res=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                for(int j=i+1;j<arr.length;j++){
                    if(arr[j]!=0){
                        res+=arr[i]*arr[j];
                        break;
                    }
                }
                    }
        }
        return res;
        
    }
}