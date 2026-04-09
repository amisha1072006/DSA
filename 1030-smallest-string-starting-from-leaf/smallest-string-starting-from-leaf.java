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
        String ans="";
    public String smallestFromLeaf(TreeNode root) {
        if(root==null)return "";
        helper(root,new StringBuilder());
        return ans;
    }

    void helper(TreeNode root,StringBuilder s){
       if(root==null) return;
       s.insert(0,(char)('a'+root.val));
       if(root.left==null && root.right==null){
        ans=(ans==""|| s.toString().compareTo(ans)<0) ? s.toString():ans;
       }
       helper(root.left,s);
       helper(root.right,s);
       s.deleteCharAt(0);
    }
}