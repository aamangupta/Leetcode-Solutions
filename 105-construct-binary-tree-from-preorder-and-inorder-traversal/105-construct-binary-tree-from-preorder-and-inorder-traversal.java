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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int ps = 0, is = 0;
        int pe = preorder.length - 1;
        int ie = inorder.length - 1;
        return helper(preorder, inorder, ps, pe, is, ie);
    }
    public TreeNode helper(int []pre, int []in, int ps, int pe, int is, int ie){
        if(ps > pe || is > ie) return null;
        
        int idx = is;
        while(in[idx] != pre[ps]) idx++;
        
        int colse = idx - is;
        
        TreeNode node = new TreeNode(pre[ps]);
        
        node.left = helper(pre, in, ps + 1, ps + colse, is, idx - 1);
        node.right = helper(pre, in, ps + colse + 1, pe, idx + 1, ie);
        
        return node;
    }
}