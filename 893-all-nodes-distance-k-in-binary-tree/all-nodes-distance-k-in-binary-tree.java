/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
              Map<TreeNode,TreeNode> map = new HashMap<>();
        markParent(root,map);

        Queue<TreeNode> que = new LinkedList<>();
        Map<TreeNode,Boolean> visited = new HashMap<>();

        que.add(target);
visited.put(target, true); 
        while(!que.isEmpty()){

            int curSize = que.size();
            if(k == 0)break;
            k--;

            for(int i = 0;i< curSize;i++){

                TreeNode current = que.poll();
                if (current.left != null && visited.get(current.left) == null) {
                    que.offer(current.left);
                    visited.put(current.left, true);
                }
                if (current.right != null && visited.get(current.right) == null) {
                    que.offer(current.right);
                    visited.put(current.right, true);
                }
                if (map.get(current) != null && visited.get(map.get(current)) == null) {
                    que.offer(map.get(current));
                    visited.put(map.get(current), true);
                }

            }

        }
        List<Integer> result = new ArrayList<>();
        while (!que.isEmpty()) {
            TreeNode current = que.poll();
            result.add(current.val);
        }

        return result;

    }

    private static void markParent(TreeNode root,Map<TreeNode,TreeNode> map){
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            TreeNode cur = que.poll();

            if(cur.left != null){
                que.add(cur.left);
                map.put(cur.left,cur);
            }
            
            if(cur.right != null){
                que.add(cur.right);
                map.put(cur.right,cur);
            }
        }  
    }
}