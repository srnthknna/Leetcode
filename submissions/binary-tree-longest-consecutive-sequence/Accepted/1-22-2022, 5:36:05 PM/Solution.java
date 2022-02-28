// https://leetcode.com/problems/binary-tree-longest-consecutive-sequence

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
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        helper(root, null, 0);
        return max;
    }
    
    private void helper(TreeNode root, TreeNode parent, int length) {
        if (root == null) return;
        length = (parent != null && root.val == parent.val + 1) ? length + 1 : 1;
        max = Math.max(max, length);
        helper(root.left, root, length);
        helper(root.right, root, length);
    }
}