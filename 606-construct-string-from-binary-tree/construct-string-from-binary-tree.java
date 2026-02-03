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
    public String tree2str(TreeNode root) {
        return recursion(root);
    }
        private String recursion(TreeNode root) {
        // base case
        if (root == null) return "";
        if (root.left == null && root.right == null) return String.valueOf(root.val);

        // subproblems
        String leftResult = recursion(root.left);
        String rightResult = recursion(root.right);

        // recursion rule
        if (root.right == null) {
            return String.valueOf(root.val) + "(" + leftResult + ")";
        } else {
            return (
                String.valueOf(root.val) + "(" + leftResult + ")"
                + "(" + rightResult + ")"
            );
        }
        }
}