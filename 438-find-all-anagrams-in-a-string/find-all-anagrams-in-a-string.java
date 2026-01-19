class Solution {
    public List<Integer> findAnagrams(String s, String p) {
               int[] freq1 = new int[26]; // Frequency of current window in 's'
        int[] freq2 = new int[26]; // Frequency of characters in 'p'
        List<Integer> list = new ArrayList<>();

        // If 's' is shorter than 'p', no anagrams possible
        if (s.length() < p.length())
            return list;

        // Initialize frequency arrays with the first 'p.length()' characters
        for (int i = 0; i < p.length(); i++) {
            freq1[s.charAt(i) - 'a']++;
            freq2[p.charAt(i) - 'a']++;
        }

        int start = 0, end = p.length();

        // Check if initial window is an anagram
        if (Arrays.equals(freq1, freq2))
            list.add(start);

        // Slide the window over the rest of 's'
        while (end < s.length()) {
            freq1[s.charAt(start) - 'a']--; // Remove leftmost char of previous window
            freq1[s.charAt(end) - 'a']++;   // Add new char to current window

            start++;
            end++;

            // If window frequencies match, it's an anagram
            if (Arrays.equals(freq1, freq2))
                list.add(start);
        }

        return list;
     
    }
}