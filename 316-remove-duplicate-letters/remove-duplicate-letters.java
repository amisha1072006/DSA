class Solution {
    public String removeDuplicateLetters(String s) {
                int len = s.length();
        boolean pres[] = new boolean[26];
        int last[] = new int[26];

        for(int i =0;i<26;i++) last[i] = -1;
        for(int i =0;i<len;i++) last[s.charAt(i) - 97] = i;

        Stack<Character> stack = new Stack<>();

        for(int i =0;i<len;i++) {
            char ch = s.charAt(i);
            if(pres[ch - 97] == true) continue;
            while(!stack.isEmpty() && stack.peek() > ch && last[stack.peek() - 97] > i) {
                pres[stack.peek() - 97] = false;
                stack.pop();
            }
            stack.push(ch);
            pres[ch-97] = true;
        }

        StringBuilder result = new StringBuilder("");
        while(!stack.isEmpty())result.append(stack.pop());
        return (result.reverse()).toString();
    }
}