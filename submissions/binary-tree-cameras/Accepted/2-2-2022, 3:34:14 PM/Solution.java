// https://leetcode.com/problems/binary-tree-cameras

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
    // https://www.youtube.com/watch?v=2Gh5WPjAgJk
    
    int cam = 0;
    public int minCameraCover(TreeNode root) {
        return dfs(root) == 0 ? cam + 1 : cam;
    }
    
    //States
    // 2 has camera
    // 1 has been covered
    // 0 needs to be covered
    private int dfs(TreeNode root) {
        if (root == null) return 1;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        if (left == 0 || right == 0) {
            cam++;
            return 2;
        } else if (left == 2 || right == 2) {
            return 1;
        }
        return 0;
    }
}