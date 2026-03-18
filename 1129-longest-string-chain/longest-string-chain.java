class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        HashMap<String, Integer> dp = new HashMap<>();

        int maxChain = 1;
        
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); ++i) {
                StringBuilder temp = new StringBuilder(word);
                String prev = temp.deleteCharAt(i).toString();
                best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, best);
            maxChain = Math.max(maxChain, best);
        }
        
        return maxChain;
    }
}