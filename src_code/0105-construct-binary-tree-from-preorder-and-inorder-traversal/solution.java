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
    public TreeNode buildTree(int[] pre, int[] in) {
        return construct(pre, in, 0, pre.length - 1, 0, in.length - 1);
	}
	
	private TreeNode construct(int[] pre, int[] in, 
						   int psi, int pei, 
						   int isi, int iei){
		if(isi > iei || psi > pei){
			return null;
		}
		
		
		TreeNode node = new TreeNode();
		node.val = pre[psi];
		
		int idx = -1;
		for(int i = isi; i <= iei; i++){
			if(node.val == in[i]){
				idx = i;
				break;
			}
		}
		
		int lhs = idx - isi;
		node.left = construct(pre, in, psi + 1, psi + lhs, isi, idx - 1);
		node.right = construct(pre, in, psi + lhs + 1, pei, idx + 1, iei);
		
		return node;
	}
}
