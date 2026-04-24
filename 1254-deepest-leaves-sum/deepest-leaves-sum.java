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
        static int sum=0;
    public int deepestLeavesSum(TreeNode root) {
        int count = 0;
        sum=0;
        int max = Integer.MIN_VALUE;
        int dep = Bst(root, count, max);
        count = 0;
       
        int ans = Bstdeep(root, count, dep);
        return ans;
    }

    public static int Bst(TreeNode root, int count, int max) {
        if (root == null) {
            return count-1;
        }
        int left = Bst(root.left, count + 1, max);
        max = Math.max(max, left);
        int right = Bst(root.right, count + 1, max);
        max = Math.max(max, right);

        return max;
    }

    public static int Bstdeep(TreeNode root, int count, int depth) {
        if (root == null) {
            return sum;
        }
         if (count == depth) {
            sum += root.val;
        }
         Bstdeep(root.left, count + 1, depth);
    
        Bstdeep(root.right, count + 1, depth);
       

        return sum;
    }
}