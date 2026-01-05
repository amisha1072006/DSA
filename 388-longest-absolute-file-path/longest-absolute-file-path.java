class Solution {
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] levels = new int[paths.length + 1];
        levels[0] = -1;
        int maxLength = 0;
        for (String path : paths) {
            String name = path;
            int level = 1;
            while (name.startsWith("\t")) {
                name = name.substring(1);
                level++;
            }
            int newLength = levels[level - 1] + name.length() + 1;
            if (name.contains(".")) {
                maxLength = Math.max(maxLength, newLength);
            } else {
                levels[level] = newLength;
            }
        }
        return maxLength;

    }
}