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
    int wid = 0;
    public void helper(TreeNode node, int level, int lev, HashMap<Integer, Integer> map){
        if(node == null) return;
        if(map.containsKey(level) == false){
            map.put(level, lev);
        }
        wid = Math.max((lev - map.getOrDefault(level, 0)) + 1, wid);
        helper(node.left, level + 1, lev * 2, map);
        helper(node.right, level + 1, lev * 2 + 1, map);
    }
    public int widthOfBinaryTree(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        helper(root, 0, 0, map);
        return wid;
    }
}