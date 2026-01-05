class Solution {
    public String removeKdigits(String num, int k) {
     int n = num.length();
        if (k >= n) return "0";

        Stack<Character> stack = new Stack<>();

        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop(); 
                k--;
            }
            stack.push(c);
        }
        while (k-- > 0) {
            stack.pop();
        }


        StringBuilder ans = new StringBuilder();
        for (char c : stack) {
            ans.append(c);
        }

        while (ans.length() > 0 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }
        return ans.length() == 0 ? "0" : ans.toString();   
    }
}