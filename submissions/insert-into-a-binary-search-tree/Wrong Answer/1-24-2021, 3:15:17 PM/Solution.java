// https://leetcode.com/problems/insert-into-a-binary-search-tree

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // if (root == null) return new TreeNode(val);
        // if (root.val < val) {
        //     root.right = insertIntoBST(root.right, val);
        // } else {
        //     root.left = insertIntoBST(root.left, val);
        // }
        // return root;
        TreeNode node = root;
        while (node != null) {
            if (node.val > val) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return root;
                } else {
                    node = node.left;
                }
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return root;
                } else {
                    node = node.right;
                }
            }
        }
        return root;
    }
}