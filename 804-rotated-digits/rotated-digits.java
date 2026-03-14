class Solution {
    public int rotatedDigits(int n) {
               int count = 0;

        for(int i = 1; i <= n; i++){
            String temp = String.valueOf(i) ;
            if(temp.contains("2") || temp.contains("5") || temp.contains("6") || temp.contains("9")) {
                if(!temp.contains("3") && !temp.contains("7") && !temp.contains("4")){
                    count++;
                }
            }
        }
        
        return count;
 
    }
}