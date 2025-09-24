class Solution {
    public int[][] merge(int[][] intervals) {
                // Step 1: Handle the base case where no merging is needed.
        if (intervals.length <= 1) {
            return intervals;
        }

        // Step 2: Sort the intervals by their start time.
        // A lambda expression is used for a clean custom comparator.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 3: Use a LinkedList to store the merged intervals.
        // It provides efficient access to the last element.
        LinkedList<int[]> merged = new LinkedList<>();

        // Step 4: Iterate through the sorted intervals to merge them.
        for (int[] interval : intervals) {
            // If the merged list is empty or there's no overlap, add the new interval.
            // No overlap condition: last merged interval's end < current interval's start.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // Otherwise, there is an overlap.
            else {
                // Merge by updating the end of the last interval in the list.
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
                // Step 5: Convert the list back to a 2D array for the final output.
        return merged.toArray(new int[merged.size()][]);
    }
}