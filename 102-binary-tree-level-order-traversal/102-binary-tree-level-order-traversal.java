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
        List<List<Integer>> outer = new ArrayList <>();
        if(root == null) return outer;
        Queue <TreeNode> q = new ArrayDeque <>();
        q.add(root);
        while(q.size() > 0){
            int n = q.size();
            List<Integer> inner = new ArrayList <>();
            while(n-- > 0){
                TreeNode rem = q.remove();
                inner.add(rem.val);
                if(rem.left != null) q.add(rem.left);
                if(rem.right != null) q.add(rem.right);
            }
            outer.add(inner);
        }
        return outer;
    }
}