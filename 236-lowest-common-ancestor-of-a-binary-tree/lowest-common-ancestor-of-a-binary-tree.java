/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution{  
      public boolean exist(TreeNode root, TreeNode node){
        if (root==null) return false;
        if (node==root ) return true;
        return exist(root.left, node) || exist(root.right, node);
}

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
                if(p==root || q==root) return root;
        boolean plst = exist(root.left, p);
        boolean qlst = exist(root.left, q);
        if(plst==true && qlst==true)  return lowestCommonAncestor(root.left, p, q);
        if(plst==false && qlst==false) return lowestCommonAncestor(root.right, p, q);
        // if(plst==true && qlst==false) return root;
        // if(plst==false && qlst==true) return root;
        else return root;
    
    }
}