// https://leetcode.com/problems/closest-binary-search-tree-value

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
    double min;
    int ans;
    public int closestValue(TreeNode root, double target) {
        min = Integer.MAX_VALUE;
        inorder(root, target);
        return ans;
    }
    
    private void inorder(TreeNode root, double target) {
        if (root == null) return;
        
        inorder(root.left, target);
        
        if (min > Math.abs(root.val - target)) {
            ans = root.val;
            min = Math.abs(root.val - target);
        }
        
        inorder(root.right, target);
        
    }
}