class Solution {
    public int countOfSubstrings(String word, int k) {
        int n = word.length();
        int totalCount = 0;

        HashSet<Character> vowelsSet = new HashSet<>();
        vowelsSet.add('a');
        vowelsSet.add('e');
        vowelsSet.add('i');
        vowelsSet.add('o');
        vowelsSet.add('u');

        for (int start = 0; start < n; start++) {
            HashSet<Character> vowelsInWindow = new HashSet<>();
            int consonantCount = 0;

            for (int end = start; end < n; end++) {
                char c = word.charAt(end);
                
                if (vowelsSet.contains(c)) {
                    vowelsInWindow.add(c);
                } else if (Character.isLetter(c)) {
                    consonantCount++;
                }
                
                if (vowelsInWindow.size() == 5 && consonantCount == k) {
                    totalCount++;
                }

                if (consonantCount > k) {
                    break;
                }
            }
        }
        
        return totalCount;
   
    }
}