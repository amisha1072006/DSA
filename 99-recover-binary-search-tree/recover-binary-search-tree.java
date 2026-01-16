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
        TreeNode prev = null;
    TreeNode swap1 = null;
    TreeNode swap2 = null;
    
    public void inorder(TreeNode root) {
        if(root == null){
            return;
        }

        inorder(root.left);
            if(prev != null){
                if(root.val < prev.val){
                    if(swap2 != null){
                        swap2 = root;
                    }else{
                        swap1 = prev;
                        swap2 = root;
                    }
            }
        }
        prev = root;
        inorder(root.right);
        
    }

    public void swapVals(TreeNode node1,TreeNode node2){
        int val = node1.val;
        node1.val = node2.val;
        node2.val = val;
    }
    public void recoverTree(TreeNode root) {
        
        inorder(root);
        swapVals(swap1,swap2);
    
    }
}