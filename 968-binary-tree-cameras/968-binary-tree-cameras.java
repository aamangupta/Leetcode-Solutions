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

    int cam = 0;
    public int minCameraCover(TreeNode root) {
        // -1 : not covered
        //  0 : cam present
        //  1 : covered
        
        int sans = helper(root);
        if(sans == -1){
            cam++;
        }
        return cam;
    }
    public int helper(TreeNode node){
        if(node == null) return 1;
        
        int l = helper(node.left);
        int r = helper(node.right);
        if(l == -1 || r == -1){
            cam++;
            return 0;
        }
        else if(l == 0 || r == 0){
            return 1;
        }
        else {
            return -1;
        }
    }
}