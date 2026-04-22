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
    public int widthOfBinaryTree(TreeNode root) {
                Queue<tuple> q = new LinkedList<>();
        q.offer(new tuple(root, 1));
        int max = 1;

        while(!q.isEmpty())
        {
            int n = q.size();
            int left = q.peek().len;
            int right = 0;

            while(n-- > 0)
            {
                tuple t = q.poll();
                TreeNode cur = t.node;
                int len = t.len;

                if(cur.left != null)
                {
                    q.add(new tuple(cur.left, len * 2));
                }

                if(cur.right != null)
                {
                    q.add(new tuple(cur.right, (len * 2) + 1));
                }

                if(n == 0)
                {
                    right = len;
                }
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
class tuple
{
    TreeNode node;
    int len;

    tuple(TreeNode node, int val)
    {
        this.node = node;
        this.len = val;
    }
}