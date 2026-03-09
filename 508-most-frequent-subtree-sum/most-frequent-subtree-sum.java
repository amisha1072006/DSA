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
    public int[] findFrequentTreeSum(TreeNode root) {
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        helper(root, map);
        List<Integer> list = new ArrayList();
        
        int max = (Collections.max(map.values()));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == max){
                list.add(entry.getKey());
            }
        }
        
        int[] arr = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            arr[i] = list.get(i);
        }
        
        return arr;
    }
    public int helper(TreeNode root, Map<Integer, Integer> map){
        if(root==null) return 0;
        int left = helper(root.left, map);
        int right = helper(root.right, map);
        
        int sum = root.val+left+right;
        if(map.containsKey(sum)){
            map.put(sum, map.get(sum)+1);
        }else{
            map.put(sum, 1);
        }
        
        return sum;

    }
}