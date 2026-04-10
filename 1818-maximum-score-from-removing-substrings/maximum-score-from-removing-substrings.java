class Solution {
    public int maximumGain(String s, int x, int y) {
        if(x > y){
            return maxScore(s, "ab", x, "ba", y);
        } else {
            return maxScore(s, "ba", y, "ab", x);
        }
    }

    private int maxScore(String s, String firstPa, int firstSc, String secondPa, int secondSc){
        int total = 0;

        StringBuilder res1 = new StringBuilder();
        for(char c: s.toCharArray()){
            int len = res1.length();
            if(len > 0 && res1.charAt(len - 1) == firstPa.charAt(0) && c == firstPa.charAt(1)){
                res1.deleteCharAt(len - 1);
                total += firstSc;
            } else {
                res1.append(c);
            }
        }

        StringBuilder res2 = new StringBuilder();
        for(char c: res1.toString().toCharArray()){
            int len = res2.length();
            if(len > 0 && res2.charAt(len - 1) == secondPa.charAt(0) && c == secondPa.charAt(1)){
                res2.deleteCharAt(len - 1);
                total += secondSc;
            }else {
                res2.append(c);
            }
        }
        return total;
    }
}