class Solution {
    public int longestPalindrome(String[] words) {
               Map<String, Integer> wordCount = new HashMap<>();
        
        // Populate the map with word frequencies
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Variables to keep track of the length of the palindrome and if we can use a central word
        int center = 0;
        int length = 0;
        
        // Iterate over each word to calculate possible palindrome length
        for (String word : words) {
            // Reverse the current word
            String reversedWord = new StringBuilder(word).reverse().toString();
            
            // Check if the current word is a palindrome (same as its reverse)
            if (word.equals(reversedWord)) {
                // If the word is a palindrome, use pairs of these words
                int count = wordCount.get(word);
                length += 4 * (count / 2); // Each pair contributes 4 to the length
                if (count % 2 == 1) {
                    // If there's an odd number of palindromic words, one can be used in the center
                    center = 1;
                }
                // Set the count to zero to avoid reprocessing this word
                wordCount.put(word, 0);
            } else if (wordCount.containsKey(reversedWord)) {
                // If the word is not a palindrome but its reverse is present
                int countWord = wordCount.get(word);
                int countReversedWord = wordCount.get(reversedWord);
                // Use pairs of the current word and its reversed counterpart
                length += 4 * Math.min(countWord, countReversedWord);
                // Set counts to zero to avoid reprocessing these words
                wordCount.put(word, 0);
                wordCount.put(reversedWord, 0);
            }
        }
        
        // Add the central palindrome word if we found any
        return center * 2 + length;
     
    }
}