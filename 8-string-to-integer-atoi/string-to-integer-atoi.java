class Solution {
    public int myAtoi(String s) {
      long result=0;
        int index=0;
        boolean negative=false;

        s = s.trim();

        if(s.length()==0) return 0;
        char[] strArr = s.toCharArray();

        if(strArr[index] == '-' || strArr[index]=='+'){
            if(strArr[index] == '-')negative = true;
            index++;
        }

        for(int i=index;i<strArr.length;i++){
            if(!Character.isDigit(strArr[i])){
                break;
            }
            else{
                result = result*10+(Character.getNumericValue(strArr[i]));
            }    
            if(!negative && result>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(negative && -result<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        if(negative) result = -result;
        return (int)result;  
    }
}