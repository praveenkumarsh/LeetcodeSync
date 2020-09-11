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
    public List<List<Integer>> levelOrder(TreeNode root) {
       
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root==null){
            return res;
        }
    
        LinkedList<TreeNode> queue = new LinkedList<>();

		queue.addLast(root);
		queue.addLast(null);
        List<Integer> subL = new LinkedList<>();

		while (queue.size() > 0) {
            
			TreeNode rem = queue.removeFirst();
			if (rem != null) {
				// System.out.print(rem.data + " ");
                subL.add(rem.val);
                if(rem.left!=null){
                    queue.addLast(rem.left);
                }
                if(rem.right!=null){
                    queue.addLast(rem.right);
                }
			} else {
				// System.out.println();
                
				if (queue.size() > 0) {
					queue.addLast(null);
                    res.add(subL);
                    subL = new LinkedList<>();
				}
			}
            
		}
        
        res.add(subL);
        
        return res;
        
    }
}
