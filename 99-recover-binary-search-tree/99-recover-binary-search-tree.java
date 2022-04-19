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
    TreeNode f, s, prev;
    public void recoverTree(TreeNode root) {
        f = s = prev = null;
        helper(root);
        int temp = f.val;
        f.val = s.val;
        s.val = temp;
    }
    public void helper(TreeNode node){
        if(node == null) return;
 
        helper(node.left);
        if(prev != null && node.val < prev.val && f == null){
            f = prev;
        }
        if(prev != null && node.val < prev.val && f != null){
            s = node;
        }    
//         if(prev != null && prev.val > node.val){
//             //is it 1st mistake
//             if(f == null) f = prev;
            
//             s= node;
            
//         }
        prev = node;
        helper(node.right);
    }
}