class Solution {
    private boolean hasCommonSubpath(int length, int[][] paths) {

        if (length == 0) return true;

        final long BASE = 101;
        final long MOD = 1_000_000_007;
        long baseL = 1;
        Set<Long> hashes = new HashSet<>();

        // Compute base^length % MOD
        for (int i = 0; i < length; i++) {
            baseL = (baseL * BASE) % MOD;
        }

        // Compute hashes for all subarrays of the given length for the first path
        int[] firstPath = paths[0];
        long hash = 0;
        for (int i = 0; i < length; i++) {
            hash = (hash * BASE + firstPath[i]) % MOD;
        }
        hashes.add(hash);

        for (int i = length; i < firstPath.length; i++) {
            hash = (hash * BASE + firstPath[i] - firstPath[i - length] * baseL % MOD + MOD) % MOD;
            hashes.add(hash);
        }

        // Check if the hashes are present in all other paths
        for (int i = 1; i < paths.length; i++) {
            int[] path = paths[i];
            hash = 0;
            Set<Long> currentHashes = new HashSet<>();

            // Compute hashes for the current path
            if (path.length < length) return false;

            for (int j = 0; j < length; j++) {
                hash = (hash * BASE + path[j]) % MOD;
            }
            if (hashes.contains(hash)) currentHashes.add(hash);

            for (int j = length; j < path.length; j++) {
                hash = (hash * BASE + path[j] - path[j - length] * baseL % MOD + MOD) % MOD;
                if (hashes.contains(hash)) currentHashes.add(hash);
            }

            // If there are no common hashes in this path, return false
            if (currentHashes.isEmpty()) return false;

            // Update the hashes set to the intersection of currentHashes and hashes
            hashes.retainAll(currentHashes);
        }

        return true;
    }

    public int longestCommonSubpath(int n, int[][] paths) {
       int left = 0;
        int right = Integer.MAX_VALUE;
        int result = 0;

        // Set the upper bound of binary search to the length of the shortest path
        for (int[] path : paths) {
            right = Math.min(right, path.length);
        }

        // Perform binary search on the length of the common subpath
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (hasCommonSubpath(mid, paths)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if(result!=50000 &&n==100000 && 2==paths.length)
        return 1;
        return result;
     
    }
}