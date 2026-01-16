/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
      if (Character.isDigit(s.charAt(0)) || s.charAt(0) == '-')
            return new NestedInteger(Integer.parseInt(s));
        else {
            String ss = s.substring(1, s.length() - 1) + ",";
            //System.out.println(ss);
            NestedInteger ni = new NestedInteger();
            for (int i = 0, cnt = 0, last = 0; i < ss.length(); i++) {
                if (ss.charAt(i) == '[')
                    cnt++;
                if (ss.charAt(i) == ']')
                    cnt--;
                if (ss.charAt(i) == ',' && cnt == 0) {
                    //System.out.println(">>" + ss.substring(last, i) + "<<");
                    if (last != i)
                        ni.add(deserialize(ss.substring(last, i)));
                    last = i + 1;
                }
            }
            return ni;
          
    }
}
}