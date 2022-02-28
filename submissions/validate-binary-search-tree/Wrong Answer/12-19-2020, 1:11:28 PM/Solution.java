// https://leetcode.com/problems/validate-binary-search-tree

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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        return true && isValidBSTLeft(root.left, root.val) && isValidBSTRight(root.right, root.val);
    }
    
    private boolean isValidBSTLeft(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.val >= val) {
            return false;
        }
        return isValidBSTLeft(root.left, root.val) && isValidBSTRight(root.right, root.val);
    }
    
    private boolean isValidBSTRight(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.val <= val) {
            return false;
        }
        return isValidBSTLeft(root.left, root.val) && isValidBSTRight(root.right, root.val);
    }
}