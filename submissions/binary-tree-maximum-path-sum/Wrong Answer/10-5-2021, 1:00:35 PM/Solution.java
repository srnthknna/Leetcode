// https://leetcode.com/problems/binary-tree-maximum-path-sum

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
    int maxSum = 0;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }
    
    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int leftSum = helper(root.left);
        int rightSum = helper(root.right);
        
        maxSum = Math.max(leftSum + rightSum + root.val, maxSum);
        return Math.max(leftSum + root.val, rightSum + root.val);
    }
}