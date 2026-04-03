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
        int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root,-1);
        return ans;
    }

    public int helper(TreeNode root,int prev) {
        if(root == null) return 0;

        int left = helper(root.left,root.val);
        int right = helper(root.right,root.val);

        ans = Math.max(ans,left+right); // if there already is a consecutive univlaue path, but becasue we need to return only the one which is largest hence we keep checking the same with max.

        if(root.val == prev) return Math.max(left,right)+1;
        else return 0;

        
    }
}