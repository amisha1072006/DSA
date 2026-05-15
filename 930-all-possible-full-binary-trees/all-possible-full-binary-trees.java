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
    public List<TreeNode> allPossibleFBT(int N) {
      List<TreeNode> ans=new ArrayList<>();
		if(N%2==0){
			return ans;            
		}if(N==1){
			TreeNode root=new TreeNode(0);
			ans.add(root);
		}
		for(int i=1;i<N;i+=2){
			for(TreeNode left : allPossibleFBT(i)){
				for(TreeNode right : allPossibleFBT(N-i-1)){
					TreeNode root=new TreeNode(0);
					root.left=left;
					root.right=right;
					ans.add(root);                    
				}
			}
		}
		return ans;       
    }
}