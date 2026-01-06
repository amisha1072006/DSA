class Solution {
    public String reorganizeString(String s) {
        // Step 1: Calculate the frequency of characters in the string
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create a max heap (priority queue) to store characters with
        // their frequencies
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue() // Sorting in descending order of frequency
        );

        // Step 3: Add all characters with their frequencies to the heap
        maxHeap.addAll(charCountMap.entrySet());

        // Step 4: Initialize variables
        StringBuilder result = new StringBuilder();
        Map.Entry<Character, Integer> previous = null; // Store the last used
        // character

        // Step 5: Reorganize the string
        while (!maxHeap.isEmpty() || previous != null) {
            // If no characters can be used and there's still a 'previous' char
            if (previous != null && maxHeap.isEmpty()) {
                return ""; // Not possible to reorganize
            }

            // Step 6: Get the character with the highest frequency
            Map.Entry<Character, Integer> current = maxHeap.poll();
            result.append(current.getKey());

            // Decrease frequency since we used this character
            current.setValue(current.getValue() - 1);

            // Push the previous character back into the heap if it still has

            // occurrences left
            if (previous != null && previous.getValue() > 0) {
                maxHeap.offer(previous);
            }

            // Set current character as the new 'previous'
            previous = current.getValue() > 0 ? current : null;
        }

        return result.toString();
    
    }
}