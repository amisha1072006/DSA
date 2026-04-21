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
    public int maxLevelSum(TreeNode root) {
              if(root==null)return 0;
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        int currLevel = 1;
    Queue<TreeNode> q=new LinkedList<>();
    ArrayList<Integer> lvl=new ArrayList<>();
    q.add(root);
 
   
    while(q.size()>0){
      int  sum=0;
          int n=q.size();
                ArrayList<TreeNode> ans=new ArrayList<>();
                for(int i=0;i<n;i++){
                      TreeNode temp=q.remove();
                    
                    ans.add(temp);
                    sum+=temp.val;
                    if(temp.left!=null) q.add(temp.left);
                    if(temp.right!=null) q.add(temp.right);
                }
  if(sum > maxSum) {
                maxSum = sum;
                maxLevel = currLevel;
            }

            currLevel++;
    }
 
      return maxLevel;  
    }
}