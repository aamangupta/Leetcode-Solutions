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
    List<Integer> ans;
    public void helper(TreeNode node){
        if(node == null) return;
        helper(node.left);
        ans.add(node.val);
        helper(node.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        ans =  new ArrayList<>();
        helper(root);
        return ans;
    }
}