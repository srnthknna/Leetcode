// https://leetcode.com/problems/minimum-absolute-difference-in-bst

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
    int mindiff = Integer.MAX_VALUE;
    TreeNode prev;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return mindiff;
    }
    
    private void inorder(TreeNode root) {
        if (root== null) return;
        inorder(root.left);
        if (prev != null) mindiff = Math.min(mindiff , Math.abs(root.val - prev.val));
        prev = root;
        inorder(root.right);
    }
}