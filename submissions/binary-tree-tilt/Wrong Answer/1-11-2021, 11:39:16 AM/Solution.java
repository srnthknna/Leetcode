// https://leetcode.com/problems/binary-tree-tilt

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
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        
        //System.out.println("\n\n\n" + root.val);
        if (root.left == null && root.right == null) {
            return 0;
        }
        
        int left = 0, right = 0;
        if (root.left != null) {
            left = findTilt(root.left);
        }
        if (root.right != null) {
            right = findTilt(root.right);
        }

        return root.val + left + right;
    }
    
}