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
    public List<List<String>> printTree(TreeNode root) {
                List<List<String>> res = new ArrayList<>();
        if(root == null) return res;

        int h = height(root), m = h + 1, n = (1 << m) - 1;

        // Initialize result matrix
        String[][] temp = new String[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                temp[i][j] = "";
            }
        }

        // BFS Approach
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<int[]> posQueue = new LinkedList<>();
        
        nodeQueue.offer(root);
        posQueue.offer(new int[]{0, (n-1)/2});
        
        while(!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            int[] pos = posQueue.poll();
            int r = pos[0], c = pos[1];
            
            temp[r][c] = Integer.toString(node.val);
            
            if(node.left != null){
                nodeQueue.offer(node.left);
                posQueue.offer(new int[]{r+1, c - (1 << (h - r - 1))});
            }
            if(node.right != null){
                nodeQueue.offer(node.right);
                posQueue.offer(new int[]{r+1, c + (1 << (h - r - 1))});
            }
        }

        // Convert to required format
        for(int i = 0; i < m; i++){
            List<String> row = new ArrayList<>();
            for(int j = 0; j < n; j++){
                row.add(temp[i][j]);
            }
            res.add(row);
        }
        return res;
    }

    private int height(TreeNode node){
        if(node == null) return -1;
        return Math.max(height(node.left), height(node.right)) + 1;
    
    }
}