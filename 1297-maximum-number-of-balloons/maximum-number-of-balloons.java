class Solution {
    public int maxNumberOfBalloons(String text) {
                int[] frequency = new int[7];

        // Flags to alternate counts for 'l' and 'o'
        boolean lIsOdd = false, oIsOdd = false;

        // Convert the text to a character array
        char[] str = text.toCharArray();

        // Iterate over the characters to fill the frequency array
        for (char ch : str) {
            if (ch == 'b') {
                frequency[0]++;
            } else if (ch == 'a') {
                frequency[1]++;
            } else if (ch == 'l') {
                frequency[lIsOdd ? 2 : 3]++;
                lIsOdd = !lIsOdd;
            } else if (ch == 'o') {
                frequency[oIsOdd ? 4 : 5]++;
                oIsOdd = !oIsOdd;
            } else if (ch == 'n') {
                frequency[6]++;
            }
        }

        // Find the minimum frequency
        int minimumNumberOfInstances = Integer.MAX_VALUE;
        for (int freq : frequency) {
            minimumNumberOfInstances = Math.min(minimumNumberOfInstances, freq);
        }

        // Return the minimum number of instances
        return minimumNumberOfInstances;
    
    }
}