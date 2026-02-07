class Solution {
    public String reorganizeString(String s) {
                Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // sort by cnt
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((a,b) -> b.getValue() - a.getValue());

        // create buckets of str
        int maxFreq = list.get(0).getValue();
        StringBuilder[] buckets = new StringBuilder[maxFreq];

        // iterate over ch and cnts and fill buckets in circular fashion
        int k = 0; // bucket ind
        for (int i = 0; i < freq.size(); i++) {
            for (int j = 0; j < list.get(i).getValue(); j++) {
                int id = k % maxFreq;
                if (buckets[id] == null) buckets[id] = new StringBuilder();
                buckets[id].append(list.get(i).getKey());
                k++;
            }
        }

        // merge
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : buckets) {
            res.append(sb);
        }

        String resStr = res.toString();

        // validate

        for (int i = 0; i < resStr.length() - 1; i++) {
            if (resStr.charAt(i) == resStr.charAt(i+1)) return "";
        }

        return resStr;

    }
}