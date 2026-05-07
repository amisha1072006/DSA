class Solution {
         HashMap<Integer, Long> map = new HashMap<>();

    public int numFactoredBinaryTrees(int[] arr) {

        int mod = 1_000_000_007;
        Arrays.sort(arr);

        for (int x : arr) map.put(x, 1L);

        long total = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < i; j++) {

                if (arr[i] % arr[j] == 0) {

                    int key = arr[i] / arr[j];

                    if (map.containsKey(key)) {

                        long left = map.get(arr[j]) % mod;
                        long right = map.get(key) % mod;

                        long curr = map.get(arr[i]);

                        curr = (curr + (left * right) % mod) % mod;

                        map.put(arr[i], curr);
                    }
                }
            }

            total = (total + map.get(arr[i])) % mod;
        }

        return (int) total;   
    }
}