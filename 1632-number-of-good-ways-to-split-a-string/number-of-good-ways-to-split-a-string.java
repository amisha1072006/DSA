class Solution {
    public int numSplits(String s) {
        HashMap<Character,Integer>rightmap=new HashMap<>();
        Set<Character>leftset= new HashSet<>();
        int count=0;
        for(char ch:s.toCharArray())
        {
            rightmap.put(ch,rightmap.getOrDefault(ch,0)+1);
        }        
        for(int i=0;i<s.length()-1;i++)
        {
            char ch=s.charAt(i);
            leftset.add(ch);
            rightmap.put(ch,rightmap.get(ch)-1);
            if(rightmap.get(ch)==0)
            {
                rightmap.remove(ch);
            }
            if(leftset.size()==rightmap.size())
            {
                count++;
            }


        }
        return count;
    
    }
}