class Solution {
    public String largestPalindromic(String num) {
      HashMap<Integer,Integer> hm = new HashMap<>();
    
    for(int i=0;i<num.length();i++){
        int value = num.charAt(i) - '0';
        hm.put(value,hm.getOrDefault(value,0)+1);
    }
    
    StringBuilder sb = new StringBuilder();
    StringBuilder rev = new StringBuilder();
    
   while(true){
       
      boolean flag = false;
       for(int i=9;i>=0;i--){
           
           if(sb.length() == 0 && i == 0) continue;
           int freq = hm.getOrDefault(i,0);
           
           if(freq != 0){
                if(freq%2 == 0){
                    for(int j=1;j<=freq/2;j++){
                        sb.append(i);
                        rev.append(i);
                        flag = true;
                    }
                    hm.put(i,0);
                }
               else{
                   int value  = freq/2;
                   int mod = freq%2;
                   
                   for(int j=1;j<=value;j++){
                       sb.append(i);
                       rev.append(i);
                       flag = true;
                   }
                   hm.put(i,mod);
               }
           }
       }
       
       if(!flag) break;
   }
    
  for(int i=9;i>=0;i--){  
      if(hm.containsKey(i) && hm.get(i)>0){
          sb.append(i);
          break;
      }
  }
  String str = (sb.toString() + rev.reverse().toString());
  return str;
      
    }
}