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
    int ans = 0;
    public void helper(TreeNode node, int i, int h){
        if(node == null) return;
        if(i == h) {
            ans += node.val;
            return;
        }
        helper(node.left, i + 1, h);
        helper(node.right, i + 1, h);
    }
    public int height(TreeNode node){
        if(node == null) return -1;
        if(node.right == null && node.left == null) return 0;
        int l = height(node.left), r = height(node.right);
        return Math.max(l, r) + 1;
    }
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        int h = height(root);
        helper(root, 0, h);
        return ans;
    }
}