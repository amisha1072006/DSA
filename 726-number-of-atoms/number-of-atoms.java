class Solution {
    public String countOfAtoms(String formula) {
               Stack<HashMap<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());

        int index = 0;

        while (index < formula.length()) {

            char ch = formula.charAt(index);

            if (ch == '(') {

                stack.push(new HashMap<>());
                index++;

            } else if (ch == ')') {

                HashMap<String, Integer> map = stack.pop();
                index++;

                int count = 0;

                while (index < formula.length() && Character.isDigit(formula.charAt(index))) {
                    count = count * 10 + (formula.charAt(index) - '0');
                    index++;
                }

                count = count == 0 ? 1 : count;

                HashMap<String, Integer> prev = stack.peek();

                for (String key : map.keySet()) {
                    prev.put(key, prev.getOrDefault(key, 0) + map.get(key) * count);
                }

            } else {

                StringBuilder element = new StringBuilder();
                element.append(formula.charAt(index++));

                while (index < formula.length() && Character.isLowerCase(formula.charAt(index))) {
                    element.append(formula.charAt(index++));
                }

                int count = 0;

                while (index < formula.length() && Character.isDigit(formula.charAt(index))) {
                    count = count * 10 + (formula.charAt(index) - '0');
                    index++;
                }

                count = count == 0 ? 1 : count;

                HashMap<String, Integer> map = stack.peek();
                String el = element.toString();

                map.put(el, map.getOrDefault(el, 0) + count);
            }
        }

        HashMap<String, Integer> map = stack.peek();

        ArrayList<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        StringBuilder result = new StringBuilder();

        for (String key : keys) {
            result.append(key);
            int count = map.get(key);
            if (count > 1) result.append(count);
        }

        return result.toString();
    }
}

public class _726_Number_of_Atoms {

    public static void main(String[] args) {

        String formula = "K4(ON(SO3)2)2";

        String result = new Solution().countOfAtoms(formula);

        System.out.println(result); 
    }
}