class Solution {
    public int minValidStrings(String[] words, String target) {
               int w[] = new int[50001], h[][] = new int[words.length + 1][50001], result = -1;
        w[0] = 1;
        for (int i = 1; i <= 50000; i++) {
            w[i] = w[i - 1] * 31;
        }
        for (int i = 0; i <= words.length; i++) {
            for (int j = 0; j < (i < words.length ? words[i] : target).length(); j++) {
                h[i][j + 1] = h[i][j] + (i < words.length ? words[i] : target).charAt(j) * w[j];
            }
        }
        TreeMap<Integer, Integer> tree = new TreeMap<>(Map.of(0, 1));
        HashMap<Integer, ArrayList<Integer>> hash = new HashMap<>(Map.of(1, new ArrayList<>(List.of(0))));
        for (int i = 0; i <= target.length(); i++) {
            for (int v : hash.getOrDefault(i, new ArrayList<>())) {
                tree.put(v, tree.get(v) - 1);
                if (tree.get(v) == 0) {
                    tree.remove(v);
                }
            }
            result = tree.isEmpty() ? -1 : tree.firstKey();
            if (!tree.isEmpty()) {
                int left = 0;
                for (int j = 0; j < words.length; j++) {
                    for (int right = Math.min(words[j].length(), target.length() - i); left < right;) {
                        int mid = (left + right + 1) / 2;
                        if (h[words.length][mid + i] - h[words.length][i] == h[j][mid] * w[i]) {
                            left = mid;
                        } else {
                            right = mid - 1;
                        }
                    }
                }
                if (left > 0) {
                    tree.put(result + 1, tree.getOrDefault(result + 1, 0) + 1);
                    hash.computeIfAbsent(i + left + 1, t -> new ArrayList<>()).add(result + 1);
                }
            }
        }
        return result;
     
    }
}