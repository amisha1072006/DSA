class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int ans = 0, i = 0;
        for(final int house : houses) {
            while(i + 1 < heaters.length && house - heaters[i] > heaters[i + 1] - house)
                i++;
            ans = Math.max(ans, Math.abs(heaters[i] - house));
        }

        return ans;
    }
}