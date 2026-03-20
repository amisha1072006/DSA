class Solution {
    public int maximumSum(int[] nums) {
        Arrays.sort(nums);
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        for (int i : nums) {
            if (i % 3 == 0)
                a.add(i);
            else if (i % 3 == 1)
                b.add(i);
            else
                c.add(i);
        }
        int ans = 0, as = a.size(), bs = b.size(), cs = c.size();
        if (as >= 3)
            ans = Math.max(ans, a.get(as - 1) + a.get(as - 2) + a.get(as - 3));
        if (bs >= 3)
            ans = Math.max(ans, b.get(bs - 1) + b.get(bs - 2) + b.get(bs - 3));
        if (cs >= 3)
            ans = Math.max(ans, c.get(cs - 1) + c.get(cs - 2) + c.get(cs - 3));
        if (as > 0 && bs > 0 && cs > 0)
            ans = Math.max(ans, a.get(as - 1) + b.get(bs - 1) + c.get(cs - 1));
        return ans;

    }
}