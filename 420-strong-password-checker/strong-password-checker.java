class Solution {
    public int strongPasswordChecker(String s) {
               if (s.length() == 0)
            return 6;
        // edge case where s size is 1
        if (s.length() == 1)
            return 5;
        
        int cnt = 0; // no. of changes needed for consecutive characters
        Map<String, Integer> mpp = new HashMap<>();
        int i = 0;

        // We use a hashmap to check the number of 1.) Uppercases' 2.) Lowercases' 3.) Numbers
        while (i < s.length()) {
            if (Character.isUpperCase(s.charAt(i))) mpp.put("uppercase", mpp.getOrDefault("uppercase", 0) + 1);
            else if (Character.isLowerCase(s.charAt(i))) mpp.put("lowercase", mpp.getOrDefault("lowercase", 0) + 1);
            else if (Character.isDigit(s.charAt(i))) mpp.put("digits", mpp.getOrDefault("digits", 0) + 1);

            // checking if there are 3 consecutive characters
            int j = i;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) j++;
            int len = j - i;
            if (len >= 3) cnt += len / 3;
            i = j;
        }

        int cnt1 = 0; // To check if one of the alphanumeric's is not present in the password
        if (!mpp.containsKey("uppercase")) cnt1++;
        if (!mpp.containsKey("lowercase")) cnt1++;
        if (!mpp.containsKey("digits")) cnt1++;

        // If the password size is less than 6, return the number of characters needed to reach size 6
        if (s.length() < 6) {
            return Math.max(6 - s.length(), cnt1);
        } 
        else if (s.length() > 20) {
            int len = s.length() - 20; 
            int[] res = new int[3]; // No. of reductions needed when 3 consecutive characters are present in a series
            i = 0;
            while (i < s.length()) {
                int j = i;
                while (j < s.length() && s.charAt(i) == s.charAt(j)) j++;
                int lenConsec = j - i;
                if (lenConsec >= 3) {
                    res[lenConsec % 3]++;
                }
                i = j;
            }

            for (int k = 0; k < 3; k++) {
                if (len <= 0) break;
                int mini = Math.min(res[k], len / (k + 1));
                cnt -= mini;
                len -= mini * (k + 1);
            }

            cnt -= len / 3;
            return (s.length() - 20) + Math.max(cnt, cnt1);
        }
        
        // If the size is within limits, return maximum of missing types or required consecutive fixes
        return Math.max(cnt, cnt1);
     
    }
}