class Solution {
    public List<String> letterCasePermutation(String s) {
       List<String> ll=new ArrayList<>();
        rec(s,"",0,ll);
        return ll;
    }
    public static void rec(String s,String ans,int idx,List<String> ll){
        if(s.length()==0){
            ll.add(ans);
            return;
        }
        char ch=s.charAt(0);
        if(Character.isLetter(ch)){
            if(Character.isUpperCase(ch)){
                rec(s.substring(1),ans+s.charAt(0),idx+1,ll);
                rec(s.substring(1),ans+s.toLowerCase().charAt(0),idx+1,ll);
            }
            else{
                rec(s.substring(1),ans+s.charAt(0),idx+1,ll);
                rec(s.substring(1),ans+s.toUpperCase().charAt(0),idx+1,ll);
            }
            
        }
        else{
            rec(s.substring(1),ans+s.charAt(0),idx+1,ll);
        } 
    }
}