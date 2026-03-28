/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
        private int find(TreeNode root, long targetSum, HashMap<Long, Long> map, long sum) {
        // Base case: if we reach null node, return 0
        if (root == null) {
            return 0;
        }

        // Update the running prefix sum
        long newSum = sum + root.val;

        // Count how many paths end at this node that sum up to targetSum
        int path = 0;

        // Case 1: if current prefix sum == targetSum, that's one valid path
        // Case 2: if (newSum - targetSum) exists in map, it means there is a previous prefix
        //         such that the subarray between that prefix and current prefix equals targetSum
        if (newSum == targetSum || map.containsKey(newSum - targetSum)) {
            path += map.getOrDefault(newSum - targetSum, 0L);
        }

        // Store the current prefix sum in the map (increase its frequency count)
        map.put(newSum, map.getOrDefault(newSum, 0L) + 1);

        // Recurse left and right to explore all possible paths
        path += find(root.left, targetSum, map, newSum);
        path += find(root.right, targetSum, map, newSum);

        // Backtrack step:
        // Once we are done exploring both children, reduce the count of newSum in map
        // This ensures that when we return to parent, paths from current node are not reused
        map.put(newSum, map.get(newSum) - 1);

        // If frequency becomes 0, remove it from map (cleanup)
        if (map.get(newSum) == 0) {
            map.remove(newSum);
        }

        return path;
    }

    // Main function
    public int pathSum(TreeNode root, int targetSum) {
        // HashMap stores prefix sum -> count of how many times it occurred
        HashMap<Long, Long> map = new HashMap<>();

        // Initialize with 0 prefix sum (to handle cases where prefix itself = target)
        map.put(0L, 1L);

        // Start recursive search with initial sum = 0
        return find(root, targetSum, map, 0);
        
    }
}