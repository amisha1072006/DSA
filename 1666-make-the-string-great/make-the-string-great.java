class Solution {
    public String makeGood(String s) {
                char[] chars = new char[s.length()];
        int counter = 0;

        for (char curr : s.toCharArray()) {

            if (counter > 0 && (curr ^ chars[counter - 1]) == 32) {
                counter--;
                continue;
            }

            chars[counter++] = curr;
        }

        return new String(chars, 0, counter);

    }
}