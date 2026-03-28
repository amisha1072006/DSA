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
        public void bst(TreeNode root,int c){
        if(root==null||c>=count)return ;
         if(c==count-1){
            TreeNode temp1=new TreeNode(data);
            TreeNode temp2=new TreeNode(data);
           if(root.left!=null){
                temp1.left=root.left;
                root.left=temp1;
           }else {
            root.left=temp1;
           }
           if(root.right!=null){
                temp2.right=root.right;
                root.right=temp2;
           }else {
            root.right=temp2;
           }
        }
        bst(root.left,c+1);
        bst(root.right,c+1);
    }
    int data;
    int count;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        data=val;
        count=depth;
        if(depth==1){
            TreeNode t=new TreeNode(val);
            t.left=root;
            return t;
        }
        bst(root,1);
        return root;

        
    }
}