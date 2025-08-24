class Solution {
    public String convert(String s, int numRows) {
      if(numRows == 1 || s.length() <= numRows){
        return s;
      }  
      StringBuilder [] strArr = new StringBuilder[numRows];
      for(int i =0;i<numRows;i++){
        strArr[i] = new StringBuilder();
      }
      int rows = 0;
      boolean moving = false;
      for(char ch : s.toCharArray()){
        strArr[rows].append(ch);
        if(rows == 0 || rows == numRows - 1){
            moving = !moving;
        }
        rows += moving ? 1:-1;
      }
      StringBuilder result = new StringBuilder();
      for(StringBuilder sb : strArr){
        result.append(sb);

      }
      return result.toString();
    }
}