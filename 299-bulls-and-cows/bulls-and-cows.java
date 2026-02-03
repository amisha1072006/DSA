class Solution {
    public String getHint(String secret, String guess) {
                // Frequency arrays to store unmatched digits
        int sfreq[] = new int[10];
        int gfreq[] = new int[10];
        
        int bull = 0, cow = 0;
        int s = secret.length();

        // First pass: count bulls and store remaining digits
        for (int i = 0; i < s; i++) {
            // If digits match at the same position → bull
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } 
            // Otherwise, store frequency for cow calculation
            else {
                sfreq[secret.charAt(i) - '0']++;
                gfreq[guess.charAt(i) - '0']++;
            }
        }

        // Count cows using minimum frequency of each digit
        for (int i = 0; i < 10; i++) {
            cow += Math.min(sfreq[i], gfreq[i]);
        }

        // Build result in "xAyB" format
        return bull + "A" + cow + "B";
    
    }
}