class Solution {
    public List<List<String>> groupAnagrams(String[] str) {
      List<List<String>> res = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            char[] chars = str[i].toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);

            if (map.containsKey(s)) {
                List<String> r = map.get(s);
                r.add(str[i]);
                map.put(s, r);
            } else {
                List<String> a = new ArrayList<>();
                a.add(str[i]);
                map.put(s, a);
            }
        }

        for (Map.Entry<String, List<String>> m : map.entrySet()) {
            res.add(m.getValue());
        }
        return res;
      
    }
}