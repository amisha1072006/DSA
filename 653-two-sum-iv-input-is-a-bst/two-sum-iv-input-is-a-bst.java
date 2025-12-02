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
    public boolean findTarget(TreeNode root, int k) {
             Set<Integer> set=new HashSet<>();
        return helper(root,k,set);
    }
    public boolean helper(TreeNode node,int k,Set<Integer> seen){
        if(node==null)return false;
        if(seen.contains(k-node.val))return true;
        seen.add(node.val);
        return helper(node.left,k,seen)||helper(node.right,k,seen);
   
    }
}