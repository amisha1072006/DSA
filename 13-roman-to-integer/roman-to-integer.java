class Solution {
    public int romanToInt(String s) {
    //    int ans = 0,num=0;
    //    for(int i = s.length()-1;i>=0;i--) {
    //     switch(s.charAt(i)){
    //         case 'I': num = 1;break;
    //         case 'V': num = 5;break;
    //         case 'X': num = 10;break;
    //         case 'L': num = 50;break;
    //         case 'C': num = 100;break;
    //         case 'D': num = 500;break;
    //         case 'M': num = 1000;break;
    //     }
    //     if(4 * num < ans) ans -=num;
    //     else ans +=num;
    //    } 
    //return ans;
    //}
            HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int result=0;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            int value=map.get(s.charAt(i));
            if(i+1 <n &&value <map.get(s.charAt(i+1)) )
            {
                result=result-value;
            }
            else
            {
                 result=result+value;
            }
        }
        
       return result;
    }
}