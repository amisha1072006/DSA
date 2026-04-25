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
class CBTInserter {

TreeNode node;
    List<TreeNode> curr;

    public CBTInserter(TreeNode root) {
        this.node = root;
        curr = new ArrayList<>();
        cal(root);
    }

    private void cal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode child = q.poll();
            curr.add(child);
            if (child.left != null) {
                q.add(child.left);
            }
            if (child.right != null) {
                q.add(child.right);
            }
        }
    }

    public int insert(int val) {
        int pos = curr.size() + 1;
        TreeNode parent = curr.get(pos / 2 - 1);
        TreeNode child = new TreeNode(val);
        if (pos % 2 == 0) {
            parent.left = child;
        }
        else {
            parent.right = child;
        }
        curr.add(child);
        return parent.val;
    }

    
    public TreeNode get_root() {
        return this.node;
        
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */