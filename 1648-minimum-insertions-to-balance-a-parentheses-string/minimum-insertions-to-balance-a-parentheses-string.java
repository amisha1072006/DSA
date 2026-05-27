class Solution {
    public int minInsertions(String s) {
        Stack<Character> stk=new Stack<Character>();
        int bal=0;
        for(int i=0;i<s.length();)
        {
            if(s.charAt(i)=='(')
            {
                stk.push(s.charAt(i));
                i++;
            }
            else 
            {
                //if incase stack is empty,check next character
                if(stk.empty())
                {
                    //if next character is ),then you need to add one ( for balancing,so bal++
                    if(i+1<s.length() && s.charAt(i+1)==')')
                    {
                        bal++;
                        i+=2;
                    }
                    //if next character is not ),then you need to add one ( and one ) for balancing,so bal+=2
                    else
                    {
                        bal+=2;
                        i++;
                    }
                }
                //if stack is not empty,the it means,it contains a (,so check next character
                else
                {
                    //if next character is also ) the it is already balanced
                    if(i+1<s.length() && s.charAt(i+1)==')')
                    {
                        i+=2;
                    }
                    //else one ) should be added so bal++
                    else
                    {
                        bal++;
                        i++;
                    }
                    stk.pop();
                }
            }
        }
        //if the string contains all character as ),then for each ( bal+=2
        while(!stk.empty())
        {
            stk.pop();
            bal+=2;
        }
        return bal;
    }
}