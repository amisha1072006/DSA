class Solution {
    public List<String> letterCombinations(String digits) {
      String[] map = new String[10];
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";

        List<String> ans = new ArrayList<>();

        backtrack(digits, 0, new StringBuilder(""), map, ans, digits.length());

        return ans;
    }
    
    void backtrack(String digits, int ind, StringBuilder sb, String[] map, List<String> ans, int n)
    {
        if(sb.length() == n)
        {
            ans.add(sb.toString());
            return;
        }

        int i = digits.charAt(ind) - '0';

        for(char ch : map[i].toCharArray())
        {
            sb.append(ch);
            backtrack(digits, ind + 1, sb, map, ans, n);

            sb.deleteCharAt(sb.length() - 1);
        }  
    }
}