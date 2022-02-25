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
    int maxl = -1, ans = -1; 
    public int findBottomLeftValue(TreeNode root) {
        ans = root.val;
        helper(root, 0);
        return ans;
    }
    public void helper(TreeNode node, int level){
        if(node == null) return;
        if(level > maxl){
            maxl = level;
            ans = node.val;
        }
        helper(node.left, level + 1);
        helper(node.right, level + 1);
    }
}