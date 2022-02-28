// https://leetcode.com/problems/sum-of-left-leaves

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
    public int sumOfLeftLeaves(TreeNode root) {
        return calc(root, false);
    }
    
    private int calc(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        int sum = 0;
        if (isLeft && root.left == null & root.right == null)
            sum += root.val;
        return sum + calc(root.left, true) + calc(root.right, false);
    }
}