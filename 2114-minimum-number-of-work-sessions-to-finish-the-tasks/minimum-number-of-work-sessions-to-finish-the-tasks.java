class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        int finished = 0;
        for (int i = 0; i < tasks.length; ++i) {
            finished = finished | (1 << i);
        }
        return 1 + helper(tasks, 0, sessionTime, finished, sessionTime);
    }

    HashMap<String, Integer> dp = new HashMap<>();

    public int helper(int[] tasks, int bitmap, int sessionTime, int finished, int curr) {
        if (bitmap == finished) {
            return 0; 
        }

        String key = bitmap + "-" + curr;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < tasks.length; ++i) {
            if ((bitmap & (1 << i)) == 0 && curr >= tasks[i]) {
                res = Math.min(res, helper(tasks, bitmap | (1 << i), sessionTime, finished, curr - tasks[i]));
            }
        }

        if (res == Integer.MAX_VALUE) {
            res = 1 + helper(tasks, bitmap, sessionTime, finished, sessionTime);
        }

        dp.put(key, res);

        return res;
    
    }
}