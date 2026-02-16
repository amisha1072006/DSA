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
         int ans=0;
    public int longestZigZag(TreeNode root) {
                dfs(root.left,1,true);
        dfs(root.right,1,false);
        return ans;
        
    }
    public void dfs(TreeNode node,int len,boolean isLeft)
    {
        if(node==null)
            return;
        ans=Math.max(len,ans);
        if(isLeft)
        {
            dfs(node.right,len+1,false);
            dfs(node.left,1,true);
        }
        else
        {
            dfs(node.right,1,false);
            dfs(node.left,len+1,true);
        }
    }
}