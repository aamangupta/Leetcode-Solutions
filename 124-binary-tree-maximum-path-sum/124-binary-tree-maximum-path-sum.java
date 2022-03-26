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
    int max = Integer.MIN_VALUE;
    public int helper(TreeNode node){
        if(node == null) return 0;
        
        int l = Math.max(0,helper(node.left));
        int r = Math.max(0,helper(node.right));
        
        max = Math.max(max, (node.val + l + r));
        return Math.max(l, r) + node.val;
    }
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        int val = helper(root);
        max = Math.max(max, val);
        return max;
    }
}